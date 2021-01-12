package com.gcb.testbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcb.testbackend.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	List<Doctor> findByNameIgnoreCase(String name);
	List<Doctor> findByCrm(String crm);
	List<Doctor> findByTelFix(String telFix);
	List<Doctor> findByTelCel(String TelCel);
	List<Doctor> findByCep(String Cep);
	List<Doctor> findByLogradouroIgnoreCase(String logradouro);
	List<Doctor> findByComplementoIgnoreCase(String complemento);
	List<Doctor> findByBairroIgnoreCase(String bairro);
	List<Doctor> findByLocalidadeIgnoreCase(String localidade);
	List<Doctor> findByUfIgnoreCase(String uf);
	List<Doctor> findByFirstDoctorExpertise(Integer firstExpertise);
	List<Doctor> findBySecondDoctorExpertise(Integer secondExpertise);
	List<Doctor> findByFirstDoctorExpertiseOrSecondDoctorExpertise(Integer firstExpertise, Integer secondExpertise);
}
