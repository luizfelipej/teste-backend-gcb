package com.gcb.testbackend.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcb.testbackend.entities.ExpertiseCategory;
import com.gcb.testbackend.repositories.ExpertiseCategoryRepository;
import com.gcb.testbackend.services.exceptions.ResourceNotFoundException;

@Service
public class ExpertiseCategoryService {

	@Autowired
	private ExpertiseCategoryRepository repository;

	public List<ExpertiseCategory> findAll() {
		return repository.findAll();
	}

	public ExpertiseCategory findById(Long id) {
		Optional<ExpertiseCategory> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<ExpertiseCategory> findByDoctorExpertise(Integer doctorExpertise) {
		return repository.findByDoctorExpertise(doctorExpertise);
	}

	public ExpertiseCategory insert(ExpertiseCategory obj) {
		return repository.save(obj);
	}

	public ExpertiseCategory update(Long id, ExpertiseCategory obj) {
		try {
			ExpertiseCategory entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(ExpertiseCategory entity, ExpertiseCategory obj) {
		entity.setDoctorExpertise(obj.getDoctorExpertise());
	}

}
