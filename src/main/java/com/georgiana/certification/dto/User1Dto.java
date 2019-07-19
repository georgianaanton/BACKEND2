package com.georgiana.certification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;
@Setter
public class User1Dto {
	
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



}
