package com.impact.pms.customException;

public class AppointmentNotFoundException extends RuntimeException {

	private String message;

	public AppointmentNotFoundException() {
		super();
	}

	public AppointmentNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
