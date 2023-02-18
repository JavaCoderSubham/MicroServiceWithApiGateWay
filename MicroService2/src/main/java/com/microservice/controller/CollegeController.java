package com.microservice.controller;

import java.util.List;

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
	
	
	@GetMapping("/all")
	public List<College> getAll() {
		return service.getAll();
	}
	
	@PutMapping("/update/{id}")
	public College updateCollege(@PathVariable String id, @RequestBody College college) {
		return service.updateCollege(id, college);
	}
}








