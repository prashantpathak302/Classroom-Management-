package com.classroom.Service;

import org.springframework.http.ResponseEntity;


import com.classroom.Dto.TeacherResponseDto;
import com.classroom.Dto.TimeTableRequestDto;

public interface TimeTableService {

	  
	  ResponseEntity<String>CreateTimeTable(TimeTableRequestDto  timeTableRequestDto);
	  ResponseEntity<String>UpdatedTimeTable(TimeTableRequestDto  timeTableRequestDto);
	  ResponseEntity<String>DeleteTimeTable(Long TimeTableId);
	  TeacherResponseDto getTimeTableDetails(Long TimeTableId);

}
