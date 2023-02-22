package com.microservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger log = LoggerFactory.getLogger(CollegeServiceImpl.class);
	
	@Override
	public College createCollege(College college) {
		
		log.info("createCollege(College) -> | College : {}",college);
		
		String uuid = UUID.randomUUID().toString();
		college.setCollegeId(uuid);
		log.info("createCollege(College) -> | Generated UUID and Set | College : {}",college);
		
		CollegeTracker tracker = mapper.convertValue(college, CollegeTracker.class);
		log.info("createCollege(College) -> | ObjectMapper to Map Object | CollegeTracker : {}",tracker);
		
		tracker.setMethodName("POST");
		log.info("createCollege(College) -> | setMethodName -> POST");
		tracker.setTime(LocalDateTime.now());
		log.info("createCollege(College) -> | setTime -> {}",LocalDateTime.now());
		
		CollegeTracker save2 = trackerRepository.save(tracker);
		log.info("createCollege(College) -> | CollegeTracker Save : {}",save2);
		College save = repository.save(college);
		log.info("createCollege(College) -> | College Save : {}",save);
		
		return save;
	}

	@Override
	public List<College> createListCollege(List<College> college) {
		log.info("createListCollege(List<College>) -> | List College : {}",college);
		List<College> list = new ArrayList<>();
		
		for(College temp : college) {
			;
			temp.setCollegeId(UUID.randomUUID().toString());
			log.info("createListCollege(List<College>) -> | College Add in List : {}",temp);
			list.add(temp);
		}
		
		for(College temp : college) {
			
			CollegeTracker tempTracker = mapper.convertValue(temp, CollegeTracker.class);
			log.info("createListCollege(List<College>) -> | ObjectMapper CollegeTracker : {}",tempTracker);
			tempTracker.setMethodName("POST");
			tempTracker.setTime(LocalDateTime.now());
			
			log.info("createListCollege(List<College>) -> | CollegeTracker Save : {}",tempTracker);
			trackerRepository.save(tempTracker);
			
		}
		
		log.info("createListCollege(List<College>) -> | College List Save : {}",list);
		return repository.saveAll(list);
	}

}








