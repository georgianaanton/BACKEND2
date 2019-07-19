package com.georgiana.certification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.georgiana.certification.dao.Users1Repository;
import com.georgiana.certification.entity.User1;


@Service
public class Users1Service {
	
	@Autowired
	Users1Repository userRepo;
	
	public List<User1> getAll() {

		return userRepo.findAll();
	}
	

}
