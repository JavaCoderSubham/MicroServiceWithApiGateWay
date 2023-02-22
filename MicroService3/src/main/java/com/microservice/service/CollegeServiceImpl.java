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
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	private CollegeRepository repository;
	
	@Autowired
	private CollegeTrackerRepository trackerRepository;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final Logger log = LoggerFactory.getLogger(CollegeServiceImpl.class);
	
	@Override
	public String deleteSingleCollege(String id) {
		
		log.info("deleteSingleCollege(String) -> | Id : {}",id);
		
		College getCollege = repository.findById(id)
				.orElseThrow(()-> new CollegeNotFoundException());
		log.info("deleteSingleCollege(String) -> | College : {}",getCollege);
		
		CollegeTracker tracker = mapper.convertValue(getCollege, CollegeTracker.class);
		log.info("deleteSingleCollege(String) -> | CollegeTracker : {}",tracker);
		
		tracker.setMethodName("DELETE");
		tracker.setTime(LocalDateTime.now());
		
		log.info("deleteSingleCollege(String) -> | Save CollegeTracker : {}",tracker);
		trackerRepository.save(tracker);
		
		log.info("deleteSingleCollege(String) -> | Delete College : {}",getCollege);
		repository.deleteById(id);
		
		return "Deleted... id : " + id;
	}

	@Override
	public String deleteAll() {
		log.info("deleteAll() -> | ");
		List<College> list = repository.findAll();
		log.info("deleteAll() -> | College List : {}",list);
		
		List<CollegeTracker> tracker = new ArrayList<>();
		log.info("deleteAll() -> | Create | CollegeTracker : {}",tracker);
		
		for(College x : list) {
			
			CollegeTracker temp = mapper.convertValue(x, CollegeTracker.class);
			log.info("deleteAll() -> | ObjectMapper CollegeTracker : {}",temp);
			
			temp.setMethodName("DELETE");
			temp.setTime(LocalDateTime.now());
			
			log.info("deleteAll() -> | List add CollegeTracker : {}",temp);
			tracker.add(temp);
			
		}
		
		log.info("deleteAll() -> | CollegeTracker : {}",tracker);
		trackerRepository.saveAll(tracker);
		
		repository.deleteAll();
		
		return "All Deleted...";
	}

}
















