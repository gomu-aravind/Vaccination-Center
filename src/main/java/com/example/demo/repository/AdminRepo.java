package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin,Integer>{
	Admin findByEmailAndPassword(String email,String password);
}
