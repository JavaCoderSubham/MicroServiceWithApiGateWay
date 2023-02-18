package com.microservice.exception;

public class CollegeNotFoundException extends RuntimeException {
	
	/**
	 *  College Not Found Exception Serial Version UID = 1L
	 */
	private static final long serialVersionUID = 1L;

	public CollegeNotFoundException() {
		super("College Not Found Exception");
	}
	
	public CollegeNotFoundException(String message) {
		super(message);
	}

}
