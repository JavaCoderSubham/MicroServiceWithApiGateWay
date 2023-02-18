package com.microservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.entity.College;
import com.microservice.entity.CollegeTracker;
import com.microservice.exception.CollegeNotFoundException;
import com.microservice.repository.CollegeRepository;
import com.microservice.repository.CollegeTrackerRepository;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	private CollegeRepository repository;
	
	@Autowired
	private CollegeTrackerRepository trackerRepository;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public String deleteSingleCollege(String id) {
		
		College getCollege = repository.findById(id)
				.orElseThrow(()-> new CollegeNotFoundException());
		
		CollegeTracker tracker = mapper.convertValue(getCollege, CollegeTracker.class);
		
		tracker.setMethodName("DELETE");
		tracker.setTime(LocalDateTime.now());
		
		trackerRepository.save(tracker);
		
		repository.deleteById(id);
		
		return "Deleted... id : " + id;
	}

	@Override
	public String deleteAll() {
		
		List<College> list = repository.findAll();
		
		List<CollegeTracker> tracker = new ArrayList<>();
		
		for(College x : list) {
			
			CollegeTracker temp = mapper.convertValue(x, CollegeTracker.class);
			
			temp.setMethodName("DELETE");
			temp.setTime(LocalDateTime.now());
			
			tracker.add(temp);
			
		}
		
		trackerRepository.saveAll(tracker);
		
		repository.deleteAll();
		
		return "All Deleted...";
	}

}
















