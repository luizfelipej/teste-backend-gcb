package com.gcb.testbackend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

import com.gcb.testbackend.entities.enums.DoctorExpertise;

@Entity
@Where(clause="is_active=1")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String crm;
	private Integer firstDoctorExpertise;
	private Integer secondDoctorExpertise;
	private String telFix;
	private String telCel;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	
	@Column(name="is_active")
	private Boolean active;


	public Doctor() {

	}

	public Doctor(Long id, String name, String crm, DoctorExpertise firstDoctorExpertise, DoctorExpertise secondDoctorExpertise, String telFix, String telCel, String cep) {
		super();
		this.id = id;
		this.name = name;
		this.crm = crm;
		setFirstDoctorExpertise(firstDoctorExpertise);
		setSecondDoctorExpertise(secondDoctorExpertise);
		this.telFix = telFix;
		this.telCel = telCel;
		this.cep = cep;
		this.active = true;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getTelFix() {
		return telFix;
	}

	public void setTelFix(String telFix) {
		this.telFix = telFix;
	}

	public String getTelCel() {
		return telCel;
	}

	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void activeSetTrue() {
		this.active = true;
	}

	public void activeSetFalse() {
		this.active = false;
	}
	
	
	//========== Expertise Enum get/set
	public DoctorExpertise getFirstDoctorExpertise() {
		return DoctorExpertise.valueOf(firstDoctorExpertise);
	}

	public void setFirstDoctorExpertise(DoctorExpertise doctorExpertise) {
		if (doctorExpertise != null) {
			this.firstDoctorExpertise = doctorExpertise.getCode();
		}
	}
	
	public DoctorExpertise getSecondDoctorExpertise() {
		return DoctorExpertise.valueOf(secondDoctorExpertise);
	}

	public void setSecondDoctorExpertise(DoctorExpertise doctorExpertise) {
		if (doctorExpertise != null) {
			this.secondDoctorExpertise = doctorExpertise.getCode();
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
		Doctor other = (Doctor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
