package com.georgiana.certification.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Entity
@Table(name="MENTORS1")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "MENTOR_ID"))
public class Mentor1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column(name = "USER_NAME")
	private String username;
	@NotNull
	@Column(name = "PASSWORD")
	private String password;
	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;
	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;
	private String role;
	@OneToMany(mappedBy="mentor",  cascade = CascadeType.ALL,
            orphanRemoval = true)
	private Set<Skill1> skills;
	@OneToMany(mappedBy="mentor",  cascade = CascadeType.ALL,
            orphanRemoval = true)
	private Set<Training1> trainings;
	@Column(name = "NO_TRAININGS")
	private int noTrainings;
	@Column(name = "YEARS_OF_EXPERIENCE")
	private int yearsOfExperience;
	@Column(name = "FEE")
	private long fee;
	
	
}
