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
	
	
}
