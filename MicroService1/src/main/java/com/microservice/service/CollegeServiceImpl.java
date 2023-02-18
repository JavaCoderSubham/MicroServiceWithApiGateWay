package com.microservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.entity.College;
import com.microservice.entity.CollegeTracker;
import com.microservice.repository.CollegeRepository;
import com.microservice.repository.CollegeTrackerRepository;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeRepository repository;
	
	@Autowired
	private CollegeTrackerRepository trackerRepository;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public College createCollege(College college) {
		
		String uuid = UUID.randomUUID().toString();
		
		college.setCollegeId(uuid);
		
		CollegeTracker tracker = mapper.convertValue(college, CollegeTracker.class);
		
		tracker.setMethodName("POST");
		
		tracker.setTime(LocalDateTime.now());
		
		trackerRepository.save(tracker);
		
		College save = repository.save(college);
		
		return save;
	}

	@Override
	public List<College> createListCollege(List<College> college) {
		
		List<College> list = new ArrayList<>();
		
		for(College temp : college) {
			
			temp.setCollegeId(UUID.randomUUID().toString());
			
			list.add(temp);
		}
		
		for(College temp : college) {
			
			CollegeTracker tempTracker = mapper.convertValue(temp, CollegeTracker.class);
			
			tempTracker.setMethodName("POST");
			tempTracker.setTime(LocalDateTime.now());
			
			trackerRepository.save(tempTracker);
			
		}
		
		
		return repository.saveAll(list);
	}

}








