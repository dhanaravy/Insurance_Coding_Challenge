package com.exception;

public class MinimumPaymentException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public MinimumPaymentException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
