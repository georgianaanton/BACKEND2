package com.georgiana.certification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.georgiana.certification.dao.Mentors1Repository;
import com.georgiana.certification.entity.Mentor1;

@Service
public class Mentors1Service {

	@Autowired
	Mentors1Repository mentorsRepo;

	public List<Mentor1> getAllMentors() {

		return mentorsRepo.findAll();
	}

	public String getMentorById(Long id) {
		Optional<Mentor1> mentor = mentorsRepo.findById(id);
		return mentor.get().getFirstName() + " " + mentor.get().getLastName();

	}

}
