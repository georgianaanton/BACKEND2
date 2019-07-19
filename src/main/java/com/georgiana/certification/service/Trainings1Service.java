package com.georgiana.certification.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.georgiana.certification.dao.Trainings1Repository;
import com.georgiana.certification.entity.Training1;

@Service
public class Trainings1Service {

	@Autowired
	Trainings1Repository trainingsRepo;

	public List<Training1> getAllTrainings() {

		return trainingsRepo.findAll();
	}

	public Collection<Training1> getTrainingsForUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
