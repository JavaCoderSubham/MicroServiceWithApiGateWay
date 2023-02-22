package com.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService service;
	
	private final Logger log = LoggerFactory.getLogger(CollegeController.class);
	
	@DeleteMapping("/delete/{id}")
	public String deleteSingleCollege(@PathVariable String id) {
		log.info("========= Start Delete Single Method =========");
		log.info("deleteSingleCollege() -> | Id : {}",id);
		String deleteSingleCollege = service.deleteSingleCollege(id);
		log.info("deleteSingleCollege() -> | Message : {}",deleteSingleCollege);
		log.info("========= End Delete Single Method =========");
		return deleteSingleCollege;
	}
	
	@DeleteMapping("/delete")
	public String deleteAll() {
		log.info("========= Start Delete All Method =========");
		log.info("deleteAll() -> | ");
		String deleteAll = service.deleteAll();
		log.info("deleteAll() -> | Message : {}",deleteAll);
		log.info("========= End Delete All Method =========");
		return deleteAll;
	}
	
	
	
}
