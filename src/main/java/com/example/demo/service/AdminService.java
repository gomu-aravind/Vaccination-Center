package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {

	public Admin authenticateAdmin(String email,String password);
	
	public String registerAdmin(Admin admin);
}
