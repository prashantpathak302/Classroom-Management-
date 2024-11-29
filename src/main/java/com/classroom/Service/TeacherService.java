package com.classroom.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.TeacherRequestDTO;
import com.classroom.Dto.TeacherResponseDto;


public interface TeacherService {
  ResponseEntity<String>CreateTeacher(TeacherRequestDTO teacherRequestDTO);
  ResponseEntity<String>UpdateTeacher(TeacherRequestDTO teacherRequestDTO);
  ResponseEntity<String>DeleteTeacher(Long TeacherId);
  TeacherResponseDto GetTeacherDetails(Long TeacherId);
  

}
