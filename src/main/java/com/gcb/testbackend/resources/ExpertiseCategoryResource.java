package com.gcb.testbackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gcb.testbackend.entities.ExpertiseCategory;
import com.gcb.testbackend.services.ExpertiseCategoryService;

@RestController
@RequestMapping(value = "/especialidades")
public class ExpertiseCategoryResource {

	@Autowired
	private ExpertiseCategoryService service;

	@GetMapping
	public ResponseEntity<List<ExpertiseCategory>> findAll() {
		List<ExpertiseCategory> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ExpertiseCategory> findById(@PathVariable Long id) {
		ExpertiseCategory obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/tipo/{doctorExpertise}")
	public ResponseEntity<List<ExpertiseCategory>> findByDoctorExpertise(@PathVariable Integer doctorExpertise) {
		List<ExpertiseCategory> list = service.findByDoctorExpertise(doctorExpertise);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ExpertiseCategory> insert(@RequestBody ExpertiseCategory obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ExpertiseCategory> update(@PathVariable Long id, @RequestBody ExpertiseCategory obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
