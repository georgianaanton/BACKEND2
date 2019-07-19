package com.georgiana.certification.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Entity
@Getter
public class User1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	private String role;
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Training1> userTrainings = new LinkedHashSet<>();

}
