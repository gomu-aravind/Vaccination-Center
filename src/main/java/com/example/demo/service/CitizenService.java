package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Citizen;



public interface CitizenService {
	public String AddNewCitizen(Citizen citizen);
	public List<Citizen> ShowAll();
	public Citizen getSpecificCitizen(int id);
	public int totalCitizen();
	public String ModifyCitizenSpecific(Citizen citizen,int centerid);
	public void DeleteCitizenSpecific(int crno);
	public List<Citizen> citizenBasedOnCenter(int cid);
	
}
