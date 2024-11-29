package com.classroom.Controller;




import com.classroom.Dto.TeacherRequestDTO;
import com.classroom.Service.TeacherService;
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


@RestController
@RequestMapping("/Teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(value="/add_Teacher",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public ResponseEntity<?> Create_Teacher(@RequestBody TeacherRequestDTO teacherRequestDTO)throws JsonProcessingException {

        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, teacherService.CreateTeacher(teacherRequestDTO),ApiMassage.SUCCESS);
        return apiResponse.getResponse(apiResponse);
    }

    @PutMapping(value = "/Update_Teacher",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public ResponseEntity<String>Update_Teacher(@RequestBody TeacherRequestDTO teacherRequestDTO)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, teacherService.UpdateTeacher(teacherRequestDTO),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

    @DeleteMapping(value ="/Delete_Teacher",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public  ResponseEntity<String>Delete_Teacher(@RequestParam Long TeacherId)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, teacherService.DeleteTeacher(TeacherId),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

    @GetMapping(value = "/Get_Teacher_Details",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public  ResponseEntity<String>Get_Teacher(@RequestParam Long TeacherId)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,teacherService.GetTeacherDetails(TeacherId),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

   

}