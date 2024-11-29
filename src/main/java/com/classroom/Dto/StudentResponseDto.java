package com.classroom.Dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class StudentResponseDto {

    private Long StudentId;
    
    private Long ClassroomId;
	
  	private Boolean StatusFlag;

	private Boolean VacantFlag;
	
    private Long studentDetailId;

	private String StudentName;
	
	private Date createdDate;
		
	private Date LastUpdateDate;
		
    private String StudentFatherName;
	
	private String Discretion;
}
