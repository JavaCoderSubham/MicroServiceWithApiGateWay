package com.microservice.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException() {
		super("User not Found Exception");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
