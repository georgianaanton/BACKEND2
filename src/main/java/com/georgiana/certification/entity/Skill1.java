package com.georgiana.certification.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name="SKILLS1")
@AttributeOverride(name = "id", column = @Column(name = "SKILL_ID"))
public class Skill1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name = "mentor_id", nullable = false)
	private Mentor1 mentor;
	

}
