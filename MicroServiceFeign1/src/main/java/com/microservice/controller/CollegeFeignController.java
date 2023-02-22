package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.College;
import com.microservice.service.MicroServiceCollege;

@RestController
@RequestMapping("/feign1/create")
public class CollegeFeignController {
	
	@Autowired
	private MicroServiceCollege service;
	
	private final Logger log = LoggerFactory.getLogger(CollegeFeignController.class);
	
	@GetMapping("/get")
	public List<College> getAll() {
		log.info("========= Start Get ALL Method =========");
		log.info("getAll() -> | ");
		List<College> all = service.getAll();		
		log.info("getAll() -> | College List : {}",all);
		log.info("========= End Get ALL Method =========");
		return all;
	}
	
	@PostMapping("/list")
	public List<College> createListCollege(@RequestBody List<College> list) {
		log.info("========= Start Create List Method =========");
		log.info("createListCollege(List<College>) -> | College List : {}",list);
		List<College> createCollege = service.createCollege(list);
		log.info("createListCollege(List<College>) -> | College List : {}",createCollege);
		log.info("========= End Create List Method =========");
		return createCollege;
	}
	
	@PostMapping("/single")
	public College createCollege(@RequestBody College college) {
		log.info("========= Start Create Method =========");
		log.info("createCollege(College) -> | College : {}",college);
		College createSingleCollege = service.createSingleCollege(college);
		log.info("createCollege(College) -> | College : {}",createSingleCollege);
		log.info("========= End Create Method =========");
		return createSingleCollege;
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









