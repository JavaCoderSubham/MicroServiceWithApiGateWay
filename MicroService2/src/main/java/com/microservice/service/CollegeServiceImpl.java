package com.microservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger log = LoggerFactory.getLogger(CollegeServiceImpl.class);
	
	@Override
	public College updateCollege(String id, College college) {
		
		log.info("updateCollege(String,College) -> | Id : {} | College : {}",id,college);
		
		College getCollege = repository.findById(id)
				.orElseThrow(()-> new CollegeNotFoundException("College Not Found Exception"));
		
		log.info("updateCollege(String,College) -> | ID present in Database | Id : {} | College : {}",id,getCollege);
		
		getCollege.setCollegeName(college.getCollegeName());
		getCollege.setCollegeLocation(college.getCollegeLocation());
		
		College result = repository.save(getCollege);
		log.info("updateCollege(String,College) -> | After Save : {}",result);
		
		CollegeTracker tracker = mapper.convertValue(getCollege, CollegeTracker.class);
		log.info("updateCollege(String,College) -> | ObjectMapper CollegeTracker : {}",tracker);
		tracker.setMethodName("PUT");
		tracker.setTime(LocalDateTime.now());
		
		log.info("updateCollege(String,College) -> | Save CollegeTracker : {}",tracker);
		trackerRepository.save(tracker);
		
		return result;
	}

	@Override
	public List<College> getAll() {
		
		log.info("getAll() -> | ");
		
		List<College> list = repository.findAll();
		log.info("getAll() -> | College List : {}",list);
		
		List<CollegeTracker> getCollegeTracker = new ArrayList<>();
		log.info("getAll() -> | create CollegeTracker : {}",getCollegeTracker);
		
		
		for(College col : list) {
			
			CollegeTracker temp = mapper.convertValue(col, CollegeTracker.class);
			log.info("getAll() -> | ObjectMapper CollegeTracker : {}",temp);
			
			temp.setMethodName("GET");
			temp.setTime(LocalDateTime.now());
			
			log.info("getAll() -> | CollegeTracker Add in List : {}",temp);
			getCollegeTracker.add(temp);
		}
		
		log.info("getAll() -> | CollegeTracker List : {}",getCollegeTracker);
		trackerRepository.saveAll(getCollegeTracker);
		
		return list;
	}

}
