package com.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.dal.UserJPA;
import com.signup.dto.UserDTO;
import com.signup.entity.User;
import com.signup.exceptions.UserNotSaved;

@Service
public class SignUpServiceImplimentation implements SignUpService{
	
	@Autowired
	UserJPA uDao;
	
	public boolean saveUser(UserDTO user)throws  UserNotSaved{
		
		if(!(user.getPassword().length() > 8 && user.getPassword().length() < 16))return false;
		if((user.getEmail().length() == 0))return false;
		
		User newUser = new User(user.getName(), user.getPassword(), user.getEmail());
		
		if(uDao.findByEmail(user.getEmail()).size() > 0) return false;
		
		if(uDao.save(newUser) == null) {
			throw new UserNotSaved("User Couldn't Be Saved");
		}
		
		
		return true;
	}
	
}
