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
@Table(name="TRAININGS1")
@AttributeOverride(name = "id", column = @Column(name = "TRAINING_ID"))
public class Training1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String description;
	private int rating;
	@ManyToOne
	@JoinColumn(name = "mentor_id", nullable = false)
	private Mentor1 mentor;
	

}
