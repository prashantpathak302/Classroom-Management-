package com.classroom.Dto;

import lombok.Builder;


import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
@Builder
public class ClassRoomRequestDTO {

	
    private Long ClassroomId;
    
    private LocalTime StartTime;

    private LocalTime EndTime;

    private List<DayOfWeek>days;

    private Long principalId;

    private Long StudentId;

    private Long TeacherId;

    private Boolean StatusFlag;
	
	private Boolean VacantFlag;

	private String Subject;
	
    private List<Long>StudentIds;
    private String ClassName;
}
