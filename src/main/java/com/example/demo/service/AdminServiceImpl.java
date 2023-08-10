package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	AdminRepo ar;
	
	@Override
	public Admin authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		Admin admin=null;
		if(!(email.equals("")&&password.equals(""))) {
			admin=ar.findByEmailAndPassword(email, password);
		}
		return admin;
	}

	@Override
	public String registerAdmin(Admin admin) {
		String res="err";
		if(admin!=null) {
			ar.save(admin);
			res="Success";
		}
		return res;
	}

}