package com.gcb.testbackend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcb.testbackend.entities.Medico;
import com.gcb.testbackend.repositories.MedicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Medico md1 = new Medico(null, "Luiz", 123456789, 55847212, 941069682, 04313001);
		
		medicoRepository.saveAll(Arrays.asList(md1));
		
	}

}
