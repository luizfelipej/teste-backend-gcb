package com.gcb.testbackend.entities.enums;

public enum DoctorExpertise {
	
	ALERGOLOGIA(1), 
	ANGIOLOGIA(2), 
	BUCO_MAXILO(3), 
	CARDIOLOGIA_CLINICA(4), 
	CARDIOLOGIA_INFANTIL(5),
	CIRURGIA_CABECA_E_PESCOCO(6),
	CIRURGIA_CARDIACA(7),
	CIRURGIA_DE_TORAX(8);

	private int code;

	private DoctorExpertise(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static DoctorExpertise valueOf(int code) {
		for (DoctorExpertise value : DoctorExpertise.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
