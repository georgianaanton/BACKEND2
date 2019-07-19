package com.georgiana.certification.convertor;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.georgiana.certification.dto.MentorDto;
import com.georgiana.certification.entity.Mentor1;

@Component
public class MentorConvertor implements Convertor<Mentor1, MentorDto> {

	@Autowired
	SkillConvertor skillConvertor;

	@Override
	public MentorDto convert(Mentor1 source) {
		MentorDto dto = new MentorDto();
		dto.setId(source.getId());
		dto.setUsername(source.getUsername());
		dto.setFirstName(source.getFirstName());
		dto.setLastName(source.getLastName());
		dto.setFee(source.getFee());
		dto.setNoTrainings(source.getNoTrainings());
		dto.setYearsOfExperience(source.getYearsOfExperience());
		dto.setSkills(source.getSkills().stream().map(s -> skillConvertor.convert(s)).collect(Collectors.toSet()));

		return dto;
	}

}
