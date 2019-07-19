package com.georgiana.certification.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.georgiana.certification.convertor.MentorConvertor;
import com.georgiana.certification.dto.MentorDto;
import com.georgiana.certification.exposition.CustomRequestMapping;
import com.georgiana.certification.service.Mentors1Service;

@CustomRequestMapping
public class MentorsController {

	@Autowired
	Mentors1Service mentorsService;

	@Autowired
	MentorConvertor convertor;

	@GetMapping(value = "/users/getAllMentors")
	public List<MentorDto> getAllMentors() {
		List<MentorDto> response = mentorsService.getAllMentors().stream().map(m -> convertor.convert(m)).collect(Collectors.toList());

		return response;

	}

}
