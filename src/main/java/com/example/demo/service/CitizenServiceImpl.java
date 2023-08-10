package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Center;
import com.example.demo.entity.Citizen;
import com.example.demo.repository.CitizenRepo;

@Service
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	CitizenRepo cirepo;
	
	@Override
	public String AddNewCitizen(Citizen citizen) {
		String res = "err";
		if(citizen!=null)
		{
			cirepo.save(citizen);  
			res = "Success";
		}
		return res;
	}

	@Override
	public List<Citizen> ShowAll() {
		List<Citizen>  citizens = (List<Citizen>) cirepo.findAll();
		return citizens;
	}

	@Override
	public Citizen getSpecificCitizen(int id) {
		Optional<Citizen> optionalCenter=cirepo.findById(id);
		Citizen citizen=optionalCenter.orElse(new Citizen());
		return citizen;
	}

	@Override
	public int totalCitizen() {
		List<Citizen> citizens=(List<Citizen>) cirepo.findAll();
		return citizens.size();
	}

	@Override
	public String ModifyCitizenSpecific(Citizen citizen,int centerid) {
		String res="err";
		Citizen newcitizen=cirepo.findById(citizen.getCitizenid()).orElse(null);
		if(newcitizen!=null)
		{
			newcitizen.setDoses(citizen.getDoses());
			newcitizen.setCitizenid(citizen.getCitizenid());
			newcitizen.setName(citizen.getName());
			newcitizen.setStatus(citizen.getStatus());
			Center center=new Center();
			center.setId(centerid);
			center.setCentername(citizen.getCenter().getCentername());
			center.setCity(citizen.getCenter().getCity());
			cirepo.updateCitizenCenter(citizen.getCitizenid(), center);
			newcitizen.setCenter(center);
			cirepo.save(newcitizen);
			res = "Success";
		}
		return res;
	}

	@Override
	public void DeleteCitizenSpecific(int crno) {
		cirepo.deleteById(crno);
		
	}

	@Override
	public List<Citizen> citizenBasedOnCenter(int cid) {
		List<Citizen> citizens=cirepo.findAllByCenter_Id(cid);
		return citizens;
	}

}
