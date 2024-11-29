package com.classroom.Dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class StudentRequestDto {

	private Long StudentId;
	
  	private Boolean StatusFlag;

	private Boolean VacantFlag;
	
    private Long studentDetailId;

	private String StudentName;
	
	
    private String StudentFatherName;
	
	private String Discretion;
	
}
