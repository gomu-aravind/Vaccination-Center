package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Center;
import com.example.demo.entity.Citizen;
import com.example.demo.service.AdminService;
import com.example.demo.service.CenterService;
import com.example.demo.service.CitizenService;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	@Autowired
	CenterService cs;
	
	@Autowired
	CitizenService ci;
	
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	
	//Login and Register  Part
	@GetMapping(value="/vaccinationcenter")
	public String homePage(@RequestParam("email") String email,@RequestParam("password") String password,Model m,HttpSession session) {
		
		Admin admin=as.authenticateAdmin(email, password);
		if(admin!=null) {
			session.setAttribute("name", admin.getName());
			List<Center> centers=cs.ShowAll();
			m.addAttribute("centers",centers);
			m.addAttribute("count", cs.totalCenter());
			return "homePage";
		}else {
			m.addAttribute("message","Invalid username/password");
			return "login";
		}
	}
	
	@GetMapping(value="/registeration")
	public String newUser(Model m){
		m.addAttribute("admin",new Admin());
		return "register";
	}
	
	@PostMapping(value="/newUser")
	public String register(@ModelAttribute("admin") Admin admin,Model m) {
		String result;
		result=as.registerAdmin(admin);
		if(result.equals("Success")) {
			m.addAttribute("result","Registered Successfully");
		}
		return "login";
	}
	
	@GetMapping("/vaccinationcenter/")
	public String viewAllCenter(Model m) {
		List<Center> centers=cs.ShowAll();
		m.addAttribute("centers",centers);
		m.addAttribute("count", cs.totalCenter());
		return "homePage";
	}
	
	@GetMapping(value="/logout")
	public String logoutPage(HttpSession session,Model m) {
		session.invalidate();
		m.addAttribute("thanknote","You have been logged out successfully");
		return "login";
	}
	
	//------------------------------------------------------
	//Vaccination Center part
	
	@GetMapping(value="/addCenter")
	public String toCenter() {
		return "addCenter";
	}
	
	@PostMapping(value="/regCenter")
	public String registerCenter(@RequestParam("centername") String centername,@RequestParam("centercity") String centercity,Model m) {
		if(centercity.equals("")) {
			m.addAttribute("nocity","Please select the city");
			return "addCenter";
		}else {
			Center center=new Center();
			center.setCentername(centername);
			center.setCity(centercity);
			if(cs.AddNewCenter(center).equals("Success")) {
				m.addAttribute("center",center);
			}; 
			
			return "viewCenter";
		}
	}
	
	@GetMapping("/vaccinationcenter/center/{id}")
	public String viewSpecificCenter(@PathVariable("id")String id,Model m) {
		Center center=null;
		center=cs.getSpecificCenter(Integer.parseInt(id));
		if(center!=null) {
			m.addAttribute("center",center);
			List<Citizen> citizens=ci.citizenBasedOnCenter(Integer.parseInt(id));
			m.addAttribute("citizens", citizens);
		}
		return "viewCenter";
	}
	
	@GetMapping("/vaccinationcenter/modify/{id}")
	public String toModifyCenter(@PathVariable("id") String id,Model m) {
		Center center=cs.getSpecificCenter(Integer.parseInt(id));
		m.addAttribute("center", center);
		return"modifyCenter";
	}
	
	@PostMapping("/editCenter")
	public String updateSpecificCenter(@ModelAttribute("center")Center newcenter,Model m) {
		Center center=new Center();
		center=newcenter;
		if(center.getCity().equals("")) {
			m.addAttribute("nocity","Please select the city");
			return "modifyCenter";
		}
		if(cs.ModifyCenterSpecific(center).equals("Success")){
			m.addAttribute("successCenter","Center Data is modified");
		}
		List<Center> centers=cs.ShowAll();
		m.addAttribute("centers",centers);
		m.addAttribute("count", cs.totalCenter());
		return "homePage";
	}
	
	@GetMapping("/vaccinationcenter/{id}")
	public String deleteCenter(@PathVariable("id")String id,Model m) {
		
		List<Citizen> citizens=ci.citizenBasedOnCenter(Integer.parseInt(id));
		if(citizens.isEmpty()) {
			cs.DeleteCenterSpecific(Integer.parseInt(id));
		}else {
			m.addAttribute("citmsg", "There are sone citizens record,so it can't be deleted");
		}
		List<Center> centers=cs.ShowAll();
		m.addAttribute("centers",centers);
		m.addAttribute("count", cs.totalCenter());
		return "homePage";
	}
	
	//--------------------------------------------------------
	//Citizen Part
	
	@GetMapping("/citizens")
	public String viewAllCitizens(Model m) {
		List<Citizen> citizens=ci.ShowAll();
		m.addAttribute("citizens", citizens);
		m.addAttribute("count", ci.totalCitizen());
		return "allCitizens";
	}
	
	@GetMapping(value="/addCitizen")
	public String toCitizen(Model m) {
		List<Center> center=cs.ShowAll();
		m.addAttribute("centers", center);
		m.addAttribute("count", ci.totalCitizen());
		return "addCitizen";
	}
	
	@PostMapping(value="/regCitizen")
	public String registerCitizen(
	    @RequestParam("name") String name,
	    @RequestParam("centername") String centername,
	    @RequestParam("doses") String doses,
	    @RequestParam("status") String status,
	    Model m
	) {
	    if (centername.equals("") || doses.equals("")) {
	        m.addAttribute("notselect", "Please fill the form");
	        List<Center> centers = cs.ShowAll();
	        m.addAttribute("centers", centers);
	        m.addAttribute("count", ci.totalCitizen());
	        return "addCitizen";
	    } else {
	        Citizen citizen = new Citizen();
	        citizen.setName(name);
	        citizen.setDoses(doses);
	        citizen.setStatus(status);
	        
	        Center center = cs.findCenterByCentername(centername);
	        if (center == null) {
	            m.addAttribute("notselect", "Invalid center selected");
	            List<Center> centers = cs.ShowAll();
	            m.addAttribute("centers", centers);
	            m.addAttribute("count", ci.totalCitizen());
	            return "addCitizen";
	        }
	        
	        citizen.setCenter(center);
	        if(ci.AddNewCitizen(citizen).equals("Success")) {
				m.addAttribute("citizen",citizen);
			}; 
	        return "viewCitizen";
	    }
	}
	@GetMapping("/citizens/{id}")
	public String viewSpecificCitizen(@PathVariable("id")String id,Model m) {
		Citizen citizen=null;
		citizen=ci.getSpecificCitizen(Integer.parseInt(id));
		if(citizen!=null) {
			m.addAttribute("citizen",citizen);
		}
		return "viewCitizen";
	}
	
	@GetMapping("/citizens/center/{id}")
	public String allcitizenCenter(@PathVariable("id")String id,Model m) {
		Center center=null;
		center=cs.getSpecificCenter(Integer.parseInt(id));
		if(center!=null) {
			m.addAttribute("center",center);
			List<Citizen> citizens=ci.citizenBasedOnCenter(Integer.parseInt(id));
			m.addAttribute("citizens", citizens);
		}
		return "viewCenter";
	}
	
	@GetMapping("/citizens/modify/{id}")
	public String toModifyCitizen(@PathVariable("id") String id,Model m) {
		Citizen citizen=ci.getSpecificCitizen(Integer.parseInt(id));
		m.addAttribute("citizen", citizen);
		List<String>cities=cs.getFullCity();
		List<String>centernames=cs.getFullCenter();
		m.addAttribute("cities", cities);
		m.addAttribute("centernames", centernames);
		return"modifyCitizen";
	}
	
	@PostMapping("/editCitizen")
	public String updateSpecificCitizen(@ModelAttribute("citizen")Citizen newcitizen,Model m) {
		Citizen citizen=new Citizen();
		citizen=ci.getSpecificCitizen(newcitizen.getCitizenid());
		
		//Initailizing center names and city to compare
		String oldname=citizen.getCenter().getCentername();
		String oldcity=citizen.getCenter().getCity();
		String newname=newcitizen.getCenter().getCentername();
		String newcity=newcitizen.getCenter().getCity();
		int id=cs.getCenterId(oldname);
		
		//Default --1
		if(citizen.getCenter().getCity().equals("") || citizen.getCenter().getCentername().equals("")) {
			m.addAttribute("change","Please select the dropdown");
			m.addAttribute("citizen", citizen);
			return "modifyCitizen";
		}
		
		//Check--1
		if(!(oldname.equals(newname))) {
			m.addAttribute("change","Cannot change the center name");
			m.addAttribute("citizen", citizen);
			List<String>cities=cs.getFullCity();
			List<String>centernames=cs.getFullCenter();
			m.addAttribute("cities", cities);
			m.addAttribute("centernames", centernames);
			return "modifyCitizen";
		}
		
		
		//Check--2
		if(!(oldcity.equals(newcity))) {
			m.addAttribute("change","Cannot change the center city");
			m.addAttribute("citizen", citizen);
			List<String>cities=cs.getFullCity();
			List<String>centernames=cs.getFullCenter();
			m.addAttribute("cities", cities);
			m.addAttribute("centernames", centernames);
			return "modifyCitizen";
		}
		
		
		//Imp
		if(ci.ModifyCitizenSpecific(newcitizen,id).equals("Success")){
			m.addAttribute("successCenter","Citizen Data is modified");
		}
		List<Citizen> citizens=ci.ShowAll();
		m.addAttribute("citizens",citizens);
		m.addAttribute("count", ci.totalCitizen());
		return "allCitizens";
	}
	
	
	@GetMapping("/citizens/delete/{id}")
	public String deleteCitizen(@PathVariable("id")String id,Model m) {
		
		ci.DeleteCitizenSpecific(Integer.parseInt(id));
		List<Citizen> citizens=ci.ShowAll();
		m.addAttribute("citizens",citizens);
		m.addAttribute("count", ci.totalCitizen());
		return "allCitizens";
	}
}
