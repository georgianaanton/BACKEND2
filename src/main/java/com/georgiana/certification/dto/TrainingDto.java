package com.georgiana.certification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class TrainingDto {
	
	@JsonProperty
	private String id;	
	@JsonProperty
	private String description;
	@JsonProperty
	private String mentorName;
	@JsonProperty
	private int rating;
	@JsonProperty
	private String status;
	

}
