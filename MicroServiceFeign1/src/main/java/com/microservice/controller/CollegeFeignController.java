package com.microservice.controller;

import java.util.List;

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
@RequestMapping("/feign")
public class CollegeFeignController {
	
	@Autowired
	private MicroServiceCollege service;
	
	
	@GetMapping("/all")
	public List<College> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/create/list")
	public List<College> createListCollege(@RequestBody List<College> list) {
		return service.createCollege(list);
	}
	
	@PostMapping("/create")
	public College createCollege(@RequestBody College college) {
		return service.createSingleCollege(college);
	}
	
	@PutMapping("/update/{id}")
	public College updateCollege(@PathVariable String id, @RequestBody College college) {
		return service.updateCollege(id, college);
	}
	
	
}









