package com.classroom.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TeacherResponseDto {

	private Long TeacherId;
	
	private Long TeacherDetailId;
	
	private String teacherName;
	
	private String Discretion;
	
  	private Boolean StatusFlag;
	
	private Boolean VacantFlag;
	
    private Date createdDate;
		
	private Date LastUpdateDate;


	
}
