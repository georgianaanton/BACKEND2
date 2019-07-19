package com.georgiana.certification.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class MentorDto {
	
	@JsonProperty
	private long id;	
	@JsonProperty
	private String username;
	@JsonProperty
	private String password;
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String role;
	@JsonProperty
	private Set<SkillDto> skills = new LinkedHashSet<> ();
	@JsonProperty
	private Set<TrainingDto> trainings = new LinkedHashSet<>();
	@JsonProperty
	private int noTrainings;
	@JsonProperty
	private int yearsOfExperience;
	@JsonProperty
	private long fee;
	

}
