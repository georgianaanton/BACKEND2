package com.georgiana.certification.convertor;

import org.springframework.stereotype.Component;

import com.georgiana.certification.dto.SkillDto;
import com.georgiana.certification.entity.Skill1;

@Component
public class SkillConvertor implements Convertor<Skill1, SkillDto>{

	@Override
	public SkillDto convert(Skill1 source) {
		SkillDto dto = new SkillDto();
		dto.setId(source.getId());
		dto.setDescription(source.getDescription());
		return dto;
	}

}
