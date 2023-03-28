package com.impact.pms.customException;

public class PatientAlreadyExistsException extends RuntimeException {

	private String message;

	public PatientAlreadyExistsException() {
		super();
	}

	public PatientAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	
}
