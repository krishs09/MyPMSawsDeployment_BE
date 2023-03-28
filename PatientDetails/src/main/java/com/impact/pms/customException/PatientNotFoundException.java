package com.impact.pms.customException;

public class PatientNotFoundException extends RuntimeException {

	private String message;

	public PatientNotFoundException() {
		super();
	}

	public PatientNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
