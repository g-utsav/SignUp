package com.signup.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signup.entity.User;

@Repository
public interface UserJPA extends JpaRepository<User, Integer>{

	public List<User> findByEmail(String email);
	
}
