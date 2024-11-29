package com.classroom.Service;




import com.classroom.Dto.UpdateClassroomRequestDto;




import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.ClassRoomRequestDTO;
import com.classroom.Dto.ClassRoomResponseDTO;


public interface ClassRoomService {
    public ResponseEntity<String> CreateClassRoom (  ClassRoomRequestDTO classRoomRequestDTO);
    public ResponseEntity<String> UpdateClassRoom( UpdateClassroomRequestDto updateClassroomRequestDto);
    public  ResponseEntity<ClassRoomResponseDTO> getClassRoomDetails( Long ClassroomId);
    public ResponseEntity<String>DeleteClassRoom( Long ClassroomId);
}
