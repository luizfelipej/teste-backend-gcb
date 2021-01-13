package com.gcb.testbackend.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gcb.testbackend.entities.enums.DoctorExpertise;

@Entity
@Table(name = "tb_expertise")
public class ExpertiseCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer doctorExpertise;

	@ManyToOne
	@JoinColumn(name = "responsible_id")
	private Doctor responsible;

	public ExpertiseCategory() {
	}

	public ExpertiseCategory(Long id, DoctorExpertise doctorExpertise, Doctor responsible) {
		super();
		this.id = id;
		setDoctorExpertise(doctorExpertise);
		this.responsible = responsible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Doctor getResponsible() {
		return responsible;
	}

	public void setResponsible(Doctor responsible) {
		this.responsible = responsible;
	}

	public DoctorExpertise getDoctorExpertise() {
		return DoctorExpertise.valueOf(doctorExpertise);
	}

	public void setDoctorExpertise(DoctorExpertise doctorExpertise) {
		if (doctorExpertise != null) {
			this.doctorExpertise = doctorExpertise.getCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpertiseCategory other = (ExpertiseCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
