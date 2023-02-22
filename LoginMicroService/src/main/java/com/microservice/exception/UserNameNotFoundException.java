package com.microservice.exception;

public class UserNameNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameNotFoundException() {
		super("User Name Not Found Exception");
	}
	
	public UserNameNotFoundException(String message) {
		super(message);
	}

}
