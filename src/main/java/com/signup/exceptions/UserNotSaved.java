package com.signup.exceptions;

public class UserNotSaved extends Exception{

	public UserNotSaved() {
		
	};

	public UserNotSaved(String msg) {
		super(msg);
	};
}
