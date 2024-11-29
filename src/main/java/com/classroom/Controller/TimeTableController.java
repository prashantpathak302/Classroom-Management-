package com.classroom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.Dto.TeacherRequestDTO;
import com.classroom.Dto.TimeTableRequestDto;
import com.classroom.Service.TimeTableService;
import com.classroom.api.structure.ApiMassage;
import com.classroom.api.structure.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
@RequestMapping("/TimeTable")
public class TimeTableController {

	
	@Autowired
	private TimeTableService timeTableService;
	
	 @PostMapping(value="/add_TimeTable",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	 @PreAuthorize("hasAuthority('Teacher')")
	    public ResponseEntity<?> Create_TimeTable(@RequestBody TimeTableRequestDto tableRequestDto)throws JsonProcessingException {

	        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, timeTableService .CreateTimeTable(tableRequestDto),ApiMassage.SUCCESS);
	        return apiResponse.getResponse(apiResponse);
	    }

	 
	    @PutMapping(value = "/Update_TimeTable",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAuthority('Teacher')")
		public ResponseEntity<String>Update_TimeTable(@RequestBody  TimeTableRequestDto tableRequestDto)throws JsonProcessingException{
	        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, timeTableService.UpdatedTimeTable(tableRequestDto),ApiMassage.SUCCESS);

	        return apiResponse.getResponse(apiResponse);
	    }


	    @DeleteMapping(value ="/Delete_TimeTable",produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAuthority('Teacher')")
	    public  ResponseEntity<String>Delete_TimeTable(@RequestParam Long TimeTableId)throws JsonProcessingException{
	        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,  timeTableService.DeleteTimeTable(TimeTableId),ApiMassage.SUCCESS);

	        return apiResponse.getResponse(apiResponse);
	    }


	    @GetMapping(value = "/Get_TimeTable_Details",produces = MediaType.APPLICATION_JSON_VALUE)
	    public  ResponseEntity<String>Get_TimeTable(@RequestParam Long TimeTableId)throws JsonProcessingException{
	        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, timeTableService.getTimeTableDetails(TimeTableId),ApiMassage.SUCCESS);

	        return apiResponse.getResponse(apiResponse);
	    }

}
