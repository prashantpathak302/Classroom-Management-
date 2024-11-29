package com.classroom.Controller;





import com.classroom.Dto.StudentRequestDto;
import com.classroom.Service.StudentService;
import com.classroom.api.structure.ApiMassage;
import com.classroom.api.structure.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.function.Consumer;

@RestController
@RequestMapping("/Student")
public class StudentController {

@Autowired
    private StudentService studentService;

@PostMapping(value="/add_Student",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('Principal','Teacher')")
public ResponseEntity<?> CreateStudent(@RequestBody StudentRequestDto studentRequestDto)throws JsonProcessingException {

    ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, studentService.CreateStudent(studentRequestDto),ApiMassage.SUCCESS);
     return apiResponse.getResponse(apiResponse);
}

@PutMapping(value = "/Update_Student",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('Principal','Teacher')")
public ResponseEntity<String>Update_Student(@RequestBody StudentRequestDto studentRequestDto)throws JsonProcessingException{
    ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, studentService.UpdateStudent(studentRequestDto),ApiMassage.SUCCESS);

    return apiResponse.getResponse(apiResponse);
}

@DeleteMapping(value ="/Delete_Student",produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('Principal','Teacher')")
public  ResponseEntity<String>Delete_Student(@RequestParam Long StudentId)throws JsonProcessingException{
    ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, studentService.DeleteStudent(StudentId),ApiMassage.SUCCESS);

    return apiResponse.getResponse(apiResponse);
}

@GetMapping(value = "/Get_Student_Details",produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('Principal','Teacher')")
public  ResponseEntity<String>Get_Student(@RequestParam Long StudentId)throws JsonProcessingException{
    ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, studentService.getStudentDetails(StudentId),ApiMassage.SUCCESS);

    return apiResponse.getResponse(apiResponse);
}
}
