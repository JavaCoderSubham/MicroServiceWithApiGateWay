package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.UserLogin;
import com.microservice.service.UserLoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/login")
public class UserLoginController {
	
	@Autowired
	private UserLoginService service;
	
//	Get ALL
	
	@GetMapping("/user/all")
	public ResponseEntity<List<UserLogin>> getAll() {
		log.info("======== Start Get All Method ========");
		log.info("getAll() -> | ");
		List<UserLogin> all = service.getAll();
		log.info("getAll() -> | UserLogin : {}",all);
		log.info("======== End Get All Method ========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(all);
	}
	
//	Get By UserName
	
	@GetMapping("/user/{username}")
	public ResponseEntity<UserLogin> getByUserName(@PathVariable String username) {
		log.info("======== Start Get By UserName Method ========");
		log.info("getByUserName(String) -> | Username : {}",username);
		UserLogin getUser = service.getByUserName(username);
		log.info("getByUserName(String) -> | UserLogin : {}",getUser);
		log.info("======== End Get By UserName Method ========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(getUser);
	}
	
//	Create
	
	@PostMapping("/user/create")
	public ResponseEntity<UserLogin> createUser(@RequestBody UserLogin user) {
		log.info("======== Start Create User Method ========");
		log.info("createUser(UserLogin) -> | UserLogin : {}",user);
		UserLogin create = service.createUser(user);
		log.info("createUser(UserLogin) -> | UserLogin : {}",create);
		log.info("======== End Create User Method ========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(create);
	}
	
//	Update 
	
	@PutMapping("/admin/{username}")
	public ResponseEntity<UserLogin> updateUser(@PathVariable String username, @RequestBody UserLogin user) {
		log.info("======== Start Update User Method ========");
		log.info("updateUser(String,UserLogin) -> | UserName : {} | UserLogin : {}",username,user);
		UserLogin update = service.updateUser(username, user);
		log.info("updateUser(String,UserLogin) -> | UserLogin : {}",update);
		log.info("======== End Update User Method ========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(update);
	}
	
//	Delete By UserName
	
	@DeleteMapping("/admin/{username}")
	public ResponseEntity<String> deleteByUsername(@PathVariable String username) {
		log.info("======== Start Delete By UserName Method ========");
		log.info("deleteByUsername(String) -> UserName : {}",username);
		String deleteMessage = service.deleteByUserName(username);
		log.info("deleteByUsername(String) -> Message : {}",deleteMessage);
		log.info("======== End Delete By UserName Method ========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(deleteMessage);
	}
	
//	Delete ALL
	
	@DeleteMapping("/admin/all")
	public ResponseEntity<String> deleteAll() {
		log.info("======== Start Delete All UserName Method ========");
		log.info("deleteAll() -> | ");
		String deleteAllMessage = service.deleteAll();
		log.info("deleteAll() -> | Message : {}",deleteAllMessage);
		log.info("======== End Delete All UserName Method ========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(deleteAllMessage);
	}
	

}













