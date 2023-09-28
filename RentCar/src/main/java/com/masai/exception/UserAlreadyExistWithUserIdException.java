package com.masai.exception;

public class UserAlreadyExistWithUserIdException extends RuntimeException{
	public UserAlreadyExistWithUserIdException(String m) {
		super(m);
	}
}
