package com.georgiana.certification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class SkillDto {
	
	@JsonProperty
	private String id;	
	@JsonProperty
	private String description;

}
