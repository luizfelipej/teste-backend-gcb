package com.gcb.testbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcb.testbackend.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
