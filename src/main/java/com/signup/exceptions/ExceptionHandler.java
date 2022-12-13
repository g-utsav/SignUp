package com.signup.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotSaved.class)
	public ResponseEntity<String> userNotSaved(){
		return new ResponseEntity<String>("Failed to Save User", HttpStatus.CONFLICT);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EmailAllReadyRegisteredException.class)
	public ResponseEntity<String> emailAllReadyRegistered(){
		return new ResponseEntity<String>("Email all ready Registered", HttpStatus.CONFLICT);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<String> invalidEmail(){
		return new ResponseEntity<String>("Email out of Range", HttpStatus.CONFLICT);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(PasswordOutOfRangeException.class)
	public ResponseEntity<String> passwordOutOfrange(){
		return new ResponseEntity<String>("password out of Range", HttpStatus.CONFLICT);
	}
	
	
	
}
