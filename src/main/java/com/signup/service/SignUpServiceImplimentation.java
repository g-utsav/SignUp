package com.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.dal.UserJPA;
import com.signup.dto.UserDTO;
import com.signup.entity.User;
import com.signup.exceptions.EmailAllReadyRegisteredException;
import com.signup.exceptions.InvalidEmailException;
import com.signup.exceptions.PasswordOutOfRangeException;
import com.signup.exceptions.UserNotSaved;

@Service
public class SignUpServiceImplimentation implements SignUpService{
	
	@Autowired
	UserJPA uDao;
	
	public boolean saveUser(UserDTO user)throws  UserNotSaved,PasswordOutOfRangeException,InvalidEmailException,EmailAllReadyRegisteredException{
		
		if(!(user.getPassword().length() > 8 && user.getPassword().length() < 16))throw new PasswordOutOfRangeException();
		if((user.getEmail().length() == 0))throw new InvalidEmailException();
		
		User newUser = new User(user.getName(), user.getPassword(), user.getEmail());
		
		if(uDao.findByEmail(user.getEmail()).size() > 0) throw new EmailAllReadyRegisteredException();
		
		if(uDao.save(newUser) == null) {
			throw new UserNotSaved("User Couldn't Be Saved");
		}
		
		
		return true;
	}
	
}
