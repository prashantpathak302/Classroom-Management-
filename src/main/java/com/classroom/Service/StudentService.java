package com.classroom.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.StudentRequestDto;
import com.classroom.Dto.StudentResponseDto;




public interface StudentService {

	ResponseEntity<String> CreateStudent(StudentRequestDto studentRequestDto );
	ResponseEntity<String>DeleteStudent(Long StudentId);
	ResponseEntity<String>UpdateStudent(StudentRequestDto studentRequestDto);
      StudentResponseDto getStudentDetails(Long StudentId);
}
