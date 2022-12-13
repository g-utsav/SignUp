package com.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.signup.dto.UserDTO;
import com.signup.exceptions.UserNotSaved;
import com.signup.service.SignUpService;

@RestController
public class SignUpController {

	@Autowired
	SignUpService sServ;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody UserDTO user)throws UserNotSaved {
		if(sServ.saveUser(user)) {
			return new ResponseEntity<String>("Sucess", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
