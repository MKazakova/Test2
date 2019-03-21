package com.aftertest.exceptions;

public class BadBadValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadBadValueException(String message) {
		super(message);
	}
	
	public BadBadValueException() {
		super("Your time is negatif, it's too BAD!");
	}
	
}
