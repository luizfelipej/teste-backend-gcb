package com.gcb.testbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcb.testbackend.entities.ExpertiseCategory;

public interface ExpertiseCategoryRepository extends JpaRepository<ExpertiseCategory, Long>{
	
	List<ExpertiseCategory> findByDoctorExpertise(Integer doctorExpertise);
	
}
