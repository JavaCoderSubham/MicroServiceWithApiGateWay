package com.microservice.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.microservice.entity.UserLogin;
import com.microservice.exception.UserNameNotFoundException;
import com.microservice.repository.UserLoginRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserLoginDtoImpl implements UserLoginDto {
	
	@Autowired
	private UserLoginRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

//	Get ALL
	
	@Override
	public List<UserLogin> getAll() {
		log.info("getAll() -> | ");
		List<UserLogin> findAll = repository.findAll();
		log.info("getAll() -> | UserLogin List | {}",findAll);
		return findAll;
	}
	
//	Get By UserName

	@Override
	public UserLogin getByUserName(String username) {
		log.info("getByUserName(String) -> | UserName : {}",username);
		UserLogin getUser = repository.findById(username)
				.orElseThrow(()-> new UserNameNotFoundException());
		log.info("getByUserName(String) -> | UserLogin : {}",getUser);
		return getUser;
	}
	
//	Update

	@Override
	public UserLogin updateUser(String username, UserLogin user) {
		log.info("updateUser(String, UserLogin) -> | UserName : {} | UserLogin : {}",username,user);
		
		UserLogin getUser = getByUserName(username);
		log.info("updateUser(String, UserLogin) -> | Id Present | UserLogin : {}",getUser);
		getUser.setUsername(user.getUsername());
		getUser.setPassword(encoder.encode(user.getPassword()));
		getUser.setRoles(user.getRoles());
		
		
		UserLogin save = repository.save(getUser);
		log.info("updateUser(String, UserLogin) -> | Save : {}",save);
		return save;
	}
	
//	Delete By UserName

	@Override
	public String deleteByUserName(String username) {
		getByUserName(username);
		log.info("deleteByUserName(String) -> | UserName : {}",username);
		repository.deleteById(username);
		log.info("deleteByUserName(String) -> | Deleted | UserName : {}",username);
		return "Deleted... UserName : "+username;
	}
	
//	Delete ALL

	@Override
	public String deleteAll() {
		log.info("deleteAll() -> | ");
		repository.deleteAll();
		log.info("All Deleted...");
		return "All Deleted...";
	}
	
//	Create

	@Override
	public UserLogin createUser(UserLogin user) {
		log.info("createUser(UserLogin) -> | UserLogin : {}",user);
		user.setPassword(encoder.encode(user.getPassword()));
		UserLogin save = repository.save(user);
		log.info("createUser(UserLogin) -> | UserLogin : {}",save);
		return save;
	}

}
