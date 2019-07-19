package com.georgiana.certification.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.georgiana.certification.dto.TrainingDto;
import com.georgiana.certification.entity.Training1;
import com.georgiana.certification.service.Mentors1Service;

@Component
public class TrainingConvertor implements Convertor<Training1, TrainingDto> {
	
	@Autowired
	Mentors1Service service;

	@Override
	public TrainingDto convert(Training1 source) {
		TrainingDto dto = new TrainingDto();
		dto.setId(source.getId());
		dto.setDescription(source.getDescription());
		dto.setRating(source.getRating());
		dto.setMentorName(service.getMentorById(source.getMentor().getId()));
		return dto;
	}

}
