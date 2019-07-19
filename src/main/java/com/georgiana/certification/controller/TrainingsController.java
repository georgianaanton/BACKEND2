package com.georgiana.certification.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.georgiana.certification.convertor.TrainingConvertor;
import com.georgiana.certification.dto.TrainingDto;
import com.georgiana.certification.exposition.CustomRequestMapping;
import com.georgiana.certification.service.Trainings1Service;

@CustomRequestMapping
public class TrainingsController {

	@Autowired
	Trainings1Service trainingsService;

	@Autowired
	TrainingConvertor convertor;

	@GetMapping(value = "/users/getAllTrainings")
	public List<TrainingDto> getAllTrainings() {
		List<TrainingDto> response = trainingsService.getAllTrainings().stream().map(m -> convertor.convert(m))
				.collect(Collectors.toList());

		return response;

	}

	@GetMapping(value = "/users/trainingsInProgress/{emailAddress}")
	public List<TrainingDto> getTrainingsForUser(@PathVariable String emailAddress) {
//		List<TrainingDto> response = trainingsService.getAllTrainings().stream().map(m -> convertor.convert(m))
//				.collect(Collectors.toList());
		
		//mock reposnse - to be removed
		List<TrainingDto> response = new ArrayList<>();
		TrainingDto dto = new TrainingDto();
		dto.setId("1");
		dto.setDescription("Full Stack Developer");
		dto.setMentorName("Arun Kumar");
		dto.setRating(4);
		dto.setStatus("confirmed");
		response.add(dto);

		return response;

	}

}
