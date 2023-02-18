package com.microservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeTracker {

	private int collegeTrackerId;
	private String collegeId;
	private String collegeName;
	private String collegeLocation;
	private LocalDateTime time;
	private String methodName;
	
}






