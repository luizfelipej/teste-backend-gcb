package com.gcb.testbackend.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcb.testbackend.entities.Doctor;
import com.gcb.testbackend.repositories.DoctorRepository;
import com.gcb.testbackend.services.exceptions.DatabaseException;
import com.gcb.testbackend.services.exceptions.ResourceNotFoundException;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repository;

	public List<Doctor> findAll() {
		return repository.findAll();
	}

	public Doctor findById(Long id) {
		Optional<Doctor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Doctor> findByName(String nome) {
		return repository.findByNameIgnoreCase(nome);
	}

	public List<Doctor> findByCrm(String crm) {
		return repository.findByCrm(crm);
	}

	public List<Doctor> findByTelFix(String telFix) {
		return repository.findByTelFix(telFix);
	}

	public List<Doctor> findByTelCel(String telCel) {
		return repository.findByTelCel(telCel);
	}

	public List<Doctor> findByCep(String cep) {
		return repository.findByCep(cep);
	}

	public List<Doctor> findByLogradouro(String logradouro) {
		return repository.findByLogradouroIgnoreCase(logradouro);
	}

	public List<Doctor> findByComplemento(String complemento) {
		return repository.findByComplementoIgnoreCase(complemento);
	}

	public List<Doctor> findByBairro(String bairro) {
		return repository.findByBairroIgnoreCase(bairro);
	}

	public List<Doctor> findByLocalidade(String localidade) {
		return repository.findByLocalidadeIgnoreCase(localidade);
	}

	public List<Doctor> findByUf(String uf) {
		return repository.findByUfIgnoreCase(uf);
	}

	public List<Doctor> findByFirstDoctorExpertise(Integer expertise) {
		return repository.findByFirstDoctorExpertise(expertise);
	}

	public List<Doctor> findBySecondDoctorExpertise(Integer expertise) {
		return repository.findBySecondDoctorExpertise(expertise);
	}

	public List<Doctor> findByFirstDoctorExpertiseOrSecondDoctorExpertise(Integer firstExpertise,
			Integer SecondExpertise) {
		return repository.findByFirstDoctorExpertiseOrSecondDoctorExpertise(firstExpertise, SecondExpertise);
	}

	public Doctor insert(Doctor obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Doctor update(Long id, Doctor obj) {
		try {
			Doctor entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Doctor entity, Doctor obj) {
		entity.setName(obj.getName());
		entity.setCrm(obj.getCrm());
		entity.setTelFix(obj.getTelFix());
		entity.setTelCel(obj.getTelCel());
		entity.setCep(obj.getCep());

	}
	
	public Doctor softDelete(Long id, Doctor obj) {
		try {
			obj.activeSetFalse();
			Doctor entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
