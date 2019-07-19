package com.georgiana.certification.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.georgiana.certification.convertor.UserConvertor;
import com.georgiana.certification.dto.User1Dto;
import com.georgiana.certification.exposition.CustomRequestMapping;
import com.georgiana.certification.service.Users1Service;

@CustomRequestMapping
public class UserController {
	
	@Autowired
	Users1Service usersService;

	@Autowired
	UserConvertor convertor;

	@GetMapping(value = "/users/users")
	public List<User1Dto> getAllMentors() {
		List<User1Dto> response = usersService.getAll().stream().map(m -> convertor.convert(m)).collect(Collectors.toList());

		return response;

	}

}
