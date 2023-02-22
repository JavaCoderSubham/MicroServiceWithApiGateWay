package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.College;
import com.microservice.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService service;
	
	private final Logger log = LoggerFactory.getLogger(CollegeController.class);
	
	
	@GetMapping("/all")
	public List<College> getAll() {
		log.info("========= Start Get ALL Method =========");
		log.info("getAll() -> | ");
		List<College> all = service.getAll();
		log.info("getAll() -> | College List : {}",all);
		log.info("========= End Get ALL Method =========");
		return all;
	}
	
	@PutMapping("/update/{id}")
	public College updateCollege(@PathVariable String id, @RequestBody College college) {
		log.info("========= Start Update Method =========");
		log.info("updateCollege(String,College) -> | Id : {} | College : {}",id,college);
		College updateCollege = service.updateCollege(id, college);
		log.info("updateCollege(String,College) -> | College : {}",updateCollege);
		log.info("========= End Update Method =========");
		return updateCollege;
	}
	
}








