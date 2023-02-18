package com.microservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CollegeTracker {

	@Id
	@GeneratedValue
	private int collegeTrackerId;
	private String collegeId;
	private String collegeName;
	private String collegeLocation;
	private LocalDateTime time;
	private String methodName;
	
}






