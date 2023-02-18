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
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeTrackerRepository trackerRepository;
	
	@Autowired
	private CollegeRepository repository;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public College updateCollege(String id, College college) {
		
		College getCollege = repository.findById(id)
				.orElseThrow(()-> new CollegeNotFoundException("College Not Found Exception"));
		
		
		getCollege.setCollegeName(college.getCollegeName());
		getCollege.setCollegeLocation(college.getCollegeLocation());
		
		College result = repository.save(getCollege);
		
		CollegeTracker tracker = mapper.convertValue(getCollege, CollegeTracker.class);
		
		tracker.setMethodName("PUT");
		tracker.setTime(LocalDateTime.now());
		
		trackerRepository.save(tracker);
		
		return result;
	}

	@Override
	public List<College> getAll() {
		
		List<College> list = repository.findAll();
		
		List<CollegeTracker> getCollegeTracker = new ArrayList<>();
		
		for(College col : list) {
			
			CollegeTracker temp = mapper.convertValue(col, CollegeTracker.class);
		
			temp.setMethodName("GET");
			temp.setTime(LocalDateTime.now());
			
			getCollegeTracker.add(temp);
			
		}
		
		trackerRepository.saveAll(getCollegeTracker);
		
		return list;
	}

}
