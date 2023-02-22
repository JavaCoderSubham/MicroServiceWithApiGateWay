package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.UserLoginDto;
import com.microservice.entity.UserLogin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private UserLoginDto dto;
	
//	Get ALL

	@Override
	public List<UserLogin> getAll() {
		log.info("getAll() -> | ");
		List<UserLogin> all = dto.getAll();
		log.info("getAll() -> | ");
		return all;
	}
	
//	Get By UserName

	@Override
	public UserLogin getByUserName(String username) {
		log.info("getByUserName(String) -> | UserName : {}",username);
		UserLogin getUser = dto.getByUserName(username);
		log.info("getByUserName(String) -> | UserLogin : {}",getUser);
		return getUser;
	}
	
//	Update 

	@Override
	public UserLogin updateUser(String username, UserLogin user) {
		log.info("updateUser(String, UserLogin) -> | UserName : {} | UserLogin : {}",username,user);
		UserLogin updateUser = dto.updateUser(username, user);
		log.info("updateUser(String, UserLogin) -> | UserLogin : {}",updateUser);
		return updateUser;
	}
	
//	Delete By UserName

	@Override
	public String deleteByUserName(String username) {
		log.info("deleteByUserName(String) -> | UserName : {}",username);
		String deleteByUserName = dto.deleteByUserName(username);
		log.info("deleteByUserName(String) -> | Message : {}",deleteByUserName);
		return deleteByUserName;
	}
	
//	Delete ALL

	@Override
	public String deleteAll() {
		log.info("deleteAll() -> | ");
		String deleteAll = dto.deleteAll();
		log.info("deleteAll() -> | Message : {}",deleteAll);
		return deleteAll;
	}
	
//	Create

	@Override
	public UserLogin createUser(UserLogin user) {
		log.info("createUser(UserLogin) -> | UserLogin : {}",user);
		String role = user.getRoles().toUpperCase();
		String[] listRole = role.split(",");
		String afterAddRole = "";
		if(listRole.length != 1) {
			for(int i =0; i<listRole.length; i++) {
				afterAddRole += "ROLE_"+listRole[i];
				if(i != listRole.length-1) {
					afterAddRole += ",";
				}
			}
			user.setRoles(afterAddRole);
		}
		else {
			user.setRoles("ROLE_"+role);
		}
		UserLogin createUser = dto.createUser(user);
		log.info("createUser(UserLogin) -> | UserLogin : {}",createUser);
		return createUser;
	}


}
