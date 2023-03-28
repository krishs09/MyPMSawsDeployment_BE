package com.impact.pms.customException;

public class DemographicDetailsNotFoundException extends RuntimeException {

	private String message;

	public DemographicDetailsNotFoundException() {
		super();
	}

	public DemographicDetailsNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
