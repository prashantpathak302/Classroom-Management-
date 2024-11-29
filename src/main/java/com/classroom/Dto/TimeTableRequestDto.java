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
public class TimeTableRequestDto {

private Long TimeTableId;
	
private Long TeacherId;
	
	private String Subject ;
	
	private Long ClassroomId;
	private LocalTime StartperiodTime;

	private LocalTime EndperiodTime;
	
	
	private String day;
	
}
