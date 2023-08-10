package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Center;
import com.example.demo.repository.CenterRepo;

@Service
public class CenterServiceImpl implements CenterService{

	@Autowired
	CenterRepo crepo;
	
	@Override
	public String AddNewCenter(Center center) {
		String res = "err";
		if(center!=null)
		{
			crepo.save(center);  // add
			res = "Success";
		}
		return res;
	}

	@Override
	public List<Center> ShowAll() {
		List<Center>  centers = (List<Center>) crepo.findAll();
		return centers;
	}

	@Override
	public int totalCenter() {
		List<Center> center=(List<Center>) crepo.findAll();
		return center.size();
	}

	@Override
	public String ModifyCenterSpecific(Center center) {
		String res="err";
		Center newcenter=crepo.findById(center.getId()).orElse(null);
		if(newcenter!=null)
		{
			newcenter.setCentername(center.getCentername());
			newcenter.setCity(center.getCity());
			crepo.save(newcenter);  // modify
			res = "Success";
		}
		return res;
	}

	@Override
	public void DeleteCenterSpecific(int crno) {
		crepo.deleteById(crno);
	}

	@Override
	public Center getSpecificCenter(int id) {
		Optional<Center> optionalCenter=crepo.findById(id);
		Center center=optionalCenter.orElse(new Center());
		return center;
	}

	@Override
	public int getCenterId(String name) {
		int id=crepo.findIdByCentername(name);
		return id;
	}

	@Override
	public Center findCenterByCentername(String centername) {
		Center center=null;
		List<Center> allcenter=(List<Center>) crepo.findAll();
		for(Center c:allcenter) {
			if(c.getCentername().equals(centername))
				center=c;
		}
		return center;
	}

	@Override
	public List<String> getFullCity() {
		List<String>cities=crepo.findDistinctCity();
		return cities;
	}

	@Override
	public List<String> getFullCenter() {
		List<String>centernames=crepo.findAllByCentername();
		return centernames;
	}

	

}
