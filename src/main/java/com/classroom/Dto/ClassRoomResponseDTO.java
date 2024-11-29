package com.classroom.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ClassRoomResponseDTO {

    private Long ClassroomId;
    
    private LocalTime StartTime;
    
    private LocalTime EndTime;

    private List<DayOfWeek> days;
    
    private Long principalId;
    
   private List <Long> StudentIds;
    
    private Long TeacherId;
    
    private Boolean StatusFlag;
	
	private Boolean VacantFlag;
	
	private Long StudentId;
	
	private String Subject;

    private  Long PclId;
    
   private String ClassName;
}
