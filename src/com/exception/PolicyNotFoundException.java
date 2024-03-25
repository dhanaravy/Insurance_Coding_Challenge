package com.exception;

public class PolicyNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public PolicyNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}