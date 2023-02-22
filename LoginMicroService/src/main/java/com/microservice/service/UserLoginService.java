package com.microservice.service;

import java.util.List;

import com.microservice.entity.UserLogin;

public interface UserLoginService {

	List<UserLogin> getAll();

	UserLogin getByUserName(String username);
	
	UserLogin createUser(UserLogin user);

	UserLogin updateUser(String username, UserLogin user);

	String deleteByUserName(String username);

	String deleteAll();

}











