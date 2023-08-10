package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Center;

public interface CenterService {

	public String AddNewCenter(Center center);
	public List<Center> ShowAll();
	public int getCenterId(String name);
	public Center getSpecificCenter(int id);
	public int totalCenter();
	public String ModifyCenterSpecific(Center center);
	public void DeleteCenterSpecific(int crno);
	public Center findCenterByCentername(String centername);
	public List<String> getFullCity();
	public List<String> getFullCenter();
	
}
