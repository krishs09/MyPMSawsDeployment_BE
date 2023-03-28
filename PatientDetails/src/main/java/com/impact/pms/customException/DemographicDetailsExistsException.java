package com.impact.pms.customException;

public class DemographicDetailsExistsException extends RuntimeException {

	private String message;
	
	
	public DemographicDetailsExistsException() {
		super();
	}

	public DemographicDetailsExistsException(String message) {
		super();
		this.message = message;

	}
}
