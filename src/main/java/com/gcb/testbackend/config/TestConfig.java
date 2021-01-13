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
		
		Doctor md1 = new Doctor(null, "Luiz", "439063218", "55847212", "941069682", "04313001");
		Doctor md2 = new Doctor(null, "jorge", "439063219", "55847212", "941069682", "04313002");
		doctorRepository.saveAll(Arrays.asList(md1, md2));
		
		
		ExpertiseCategory esp1 = new ExpertiseCategory(null, DoctorExpertise.ALERGOLOGIA, md1);
		ExpertiseCategory esp2 = new ExpertiseCategory(null, DoctorExpertise.ANGIOLOGIA, md1);
		ExpertiseCategory esp3 = new ExpertiseCategory(null, DoctorExpertise.BUCO_MAXILO, md1);
		
		ExpertiseCategory esp4 = new ExpertiseCategory(null, DoctorExpertise.ALERGOLOGIA, md2);
		ExpertiseCategory esp5 = new ExpertiseCategory(null, DoctorExpertise.CARDIOLOGIA_CLINICA, md2);
		ExpertiseCategory esp6 = new ExpertiseCategory(null, DoctorExpertise.CIRURGIA_CABECA_E_PESCOCO, md2);
		expertiseCategoryRepository.saveAll(Arrays.asList(esp1, esp2, esp3, esp4, esp5, esp6));
		
	}

}
