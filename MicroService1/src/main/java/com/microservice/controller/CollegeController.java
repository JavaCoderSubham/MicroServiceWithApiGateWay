package com.microservice.controller;

import java.util.List;

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

	@Autowired
	private CollegeService service;

	@PostMapping("/create")
	public College createCollege(@RequestBody College college) {
		return service.createCollege(college);
	}
	
	@PostMapping("/create/all")
	public List<College> createListCollege(@RequestBody List<College> college) {
		return service.createListCollege(college);
	}

}
