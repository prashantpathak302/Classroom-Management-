package com.classroom.Dto;



import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequestDTO {
    
	private Long TimeTableId;
	private Long TeacherId;
	
	 private Long ClassroomId;
	
	private String teacherName;
	
	private String Discretion ;
	
  	private Boolean StatusFlag;
	
	private Boolean VacantFlag;

	

	private String Subject ;

	private LocalTime  StartperiodTime;

	private LocalTime EndperiodTime;

	private String day;

	
}
