package com.signup.service;

import com.signup.dto.UserDTO;
import com.signup.exceptions.EmailAllReadyRegisteredException;
import com.signup.exceptions.InvalidEmailException;
import com.signup.exceptions.PasswordOutOfRangeException;
import com.signup.exceptions.UserNotSaved;

public interface SignUpService {

	public boolean saveUser(UserDTO user)throws  UserNotSaved,PasswordOutOfRangeException,InvalidEmailException,EmailAllReadyRegisteredException;
	
}
