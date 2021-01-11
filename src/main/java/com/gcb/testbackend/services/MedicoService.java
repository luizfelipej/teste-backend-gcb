package com.gcb.testbackend.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcb.testbackend.entities.Medico;
import com.gcb.testbackend.repositories.MedicoRepository;
import com.gcb.testbackend.services.exceptions.DatabaseException;
import com.gcb.testbackend.services.exceptions.ResourceNotFoundException;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repository;
	
	public List<Medico> findAll() {
		return repository.findAll();
	}
	
	public Medico findById(Long id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Medico insert(Medico obj) {
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
	
	public Medico update(Long id, Medico obj) {
		try {
			Medico entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Medico entity, Medico obj) {
		entity.setNome(obj.getNome());
		entity.setCrm(obj.getCrm());
		entity.setTelFix(obj.getTelFix());
		entity.setTelCel(obj.getTelCel());
		entity.setCep(obj.getCep());

	}

}
