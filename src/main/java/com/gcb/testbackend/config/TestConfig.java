package com.gcb.testbackend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcb.testbackend.entities.Doctor;
import com.gcb.testbackend.entities.ExpertiseCategory;
import com.gcb.testbackend.entities.enums.DoctorExpertise;
import com.gcb.testbackend.repositories.DoctorRepository;
import com.gcb.testbackend.repositories.ExpertiseCategoryRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ExpertiseCategoryRepository expertiseCategoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
