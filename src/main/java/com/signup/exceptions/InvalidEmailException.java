package com.signup.exceptions;

public class InvalidEmailException extends Exception{
	public InvalidEmailException() {}
	public InvalidEmailException(String msg) {
		super(msg);
	}
}
