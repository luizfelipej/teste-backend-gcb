package com.gcb.testbackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.testbackend.entities.Doctor;
import com.gcb.testbackend.services.DoctorService;

@RestController
@RequestMapping(value = "/medicos")
public class DoctorResource {

	@Autowired
	private DoctorService service;

	@GetMapping
	public ResponseEntity<List<Doctor>> findAll() {
		List<Doctor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Doctor> findById(@PathVariable Long id) {
		Doctor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<Doctor>> findByName(@PathVariable String name) {
		List<Doctor> list = service.findByName(name);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/crm/{crm}")
	public ResponseEntity<List<Doctor>> findByCrm(@PathVariable String crm) {
		List<Doctor> list = service.findByCrm(crm);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/telFix/{telFix}")
	public ResponseEntity<List<Doctor>> findByTelFix(@PathVariable String telFix) {
		List<Doctor> list = service.findByTelFix(telFix);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/telCel/{telCel}")
	public ResponseEntity<List<Doctor>> findByTelCel(@PathVariable String telCel) {
		List<Doctor> list = service.findByTelCel(telCel);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/cep/{cep}")
	public ResponseEntity<List<Doctor>> findByCep(@PathVariable String cep) {
		List<Doctor> list = service.findByCep(cep);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/logradouro/{logradouro}")
	public ResponseEntity<List<Doctor>> findByLogradouro(@PathVariable String logradouro) {
		List<Doctor> list = service.findByLogradouro(logradouro);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/complemento/{complemento}")
	public ResponseEntity<List<Doctor>> findByComplemento(@PathVariable String complemento) {
		List<Doctor> list = service.findByComplemento(complemento);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/bairro/{bairro}")
	public ResponseEntity<List<Doctor>> findByBairro(@PathVariable String bairro) {
		List<Doctor> list = service.findByBairro(bairro);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/localidade/{localidade}")
	public ResponseEntity<List<Doctor>> findByLocalidade(@PathVariable String localidade) {
		List<Doctor> list = service.findByLocalidade(localidade);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/uf/{uf}")
	public ResponseEntity<List<Doctor>> findByUf(@PathVariable String uf) {
		List<Doctor> list = service.findByUf(uf);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/first-expertises/{firstDoctorExpertise}")
	public ResponseEntity<List<Doctor>> findByFirstDoctorExpertise(@PathVariable Integer firstDoctorExpertise) {
		List<Doctor> list = service.findByFirstDoctorExpertise(firstDoctorExpertise);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/second-expertises/{secondDoctorExpertise}")
	public ResponseEntity<List<Doctor>> findBySecondDoctorExpertise(@PathVariable Integer secondDoctorExpertise) {
		List<Doctor> list = service.findBySecondDoctorExpertise(secondDoctorExpertise);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/expertises/{firstDoctorExpertise}/{secondDoctorExpertise}")
	public ResponseEntity<List<Doctor>> findByFirstDoctorExpertiseOrSecondDoctorExpertise(@PathVariable Integer firstDoctorExpertise, @PathVariable Integer secondDoctorExpertise) {
		List<Doctor> list = service.findByFirstDoctorExpertiseOrSecondDoctorExpertise(firstDoctorExpertise, secondDoctorExpertise);
		return ResponseEntity.ok().body(list);
	}
	
	//===============================
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Doctor> softDelete(@PathVariable Long id){
		Doctor obj = service.findById(id);
		obj = service.softDelete(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
