package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.College;
import com.microservice.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	private final Logger log = LoggerFactory.getLogger(CollegeController.class);

	@Autowired
	private CollegeService service;

	@PostMapping("/create")
	public College createCollege(@RequestBody College college) {
		log.info("========= Start Create Method =========");
		log.info("createCollege(College) -> College : {}",college);
		College createCollege = service.createCollege(college);
		log.info("createCollege(College) -> College : {}",college);
		log.info("========= End Create Method =========");
		return createCollege;
	}
	
	@PostMapping("/create/all")
	public List<College> createListCollege(@RequestBody List<College> college) {
		log.info("========= Start Create List Method =========");
		log.info("createListCollege(List<College>) -> | College List : {}",college);
		List<College> createListCollege = service.createListCollege(college);
		log.info("createListCollege(List<College>) -> | College List : {}",createListCollege);
		log.info("========= End Create List Method =========");
		return createListCollege;
	}

}
