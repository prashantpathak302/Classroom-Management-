package com.classroom.Controller;


import com.classroom.Dto.ClassRoomRequestDTO;


import com.classroom.Dto.UpdateClassroomRequestDto;
import com.classroom.Service.ClassRoomService;
import com.classroom.api.structure.ApiMassage;
import com.classroom.api.structure.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @PostMapping(value="/add_ClassRoom",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   @PreAuthorize("hasAuthority('Principal')")
    public ResponseEntity<?> Create_ClassRoom(@RequestBody ClassRoomRequestDTO classRoomRequestDTO)throws JsonProcessingException {

        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,classRoomService.CreateClassRoom(classRoomRequestDTO),ApiMassage.SUCCESS);
        return apiResponse.getResponse(apiResponse);
    }

    @PutMapping(value = "/Update_ClassRoom",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public ResponseEntity<String>Update_ClassRoom(@RequestBody UpdateClassroomRequestDto updateClassroomRequestDto)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, classRoomService.UpdateClassRoom(updateClassroomRequestDto),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

    @DeleteMapping(value ="/Delete_ClassRoom",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public  ResponseEntity<String>Delete_ClassRoom(@RequestParam Long ClassroomId)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,classRoomService.DeleteClassRoom(ClassroomId),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

    @GetMapping(value = "/Get_ClassRoom_Details",produces = MediaType.APPLICATION_JSON_VALUE)

    public  ResponseEntity<String>Get_ClassRoom(@RequestParam Long ClassroomId)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,classRoomService.getClassRoomDetails(ClassroomId),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }
}