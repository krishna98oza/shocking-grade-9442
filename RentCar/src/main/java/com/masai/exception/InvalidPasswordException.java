package com.masai.exception;

public class InvalidPasswordException extends RuntimeException{
	public InvalidPasswordException(String m) {
		super(m);
	}
}
