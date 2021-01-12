package com.gcb.testbackend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcb.testbackend.entities.Doctor;
import com.gcb.testbackend.entities.enums.DoctorExpertise;
import com.gcb.testbackend.repositories.DoctorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Doctor md1 = new Doctor(null, "Luiz", "439063218", DoctorExpertise.ALERGOLOGIA, DoctorExpertise.ANGIOLOGIA, "55847212", "941069682", "04313001");
		Doctor md2 = new Doctor(null, "jorge", "439063219", DoctorExpertise.BUCO_MAXILO, DoctorExpertise.CARDIOLOGIA_CLINICA, "55847212", "941069682", "04313002");
		
		doctorRepository.saveAll(Arrays.asList(md1, md2));
		
	}

}
