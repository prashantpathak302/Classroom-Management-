package com.classroom.Controller;





import com.classroom.Dto.PrincipalRequestDto;

import com.classroom.Service.PrincipalService;
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
@RequestMapping("/Principal")
public class PrincipalController {

    @Autowired
    private PrincipalService principalService;

    @PostMapping(value="/add_Principal",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public ResponseEntity<?> Create_Principal(@RequestBody PrincipalRequestDto principalRequestDTO)throws JsonProcessingException {

        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,principalService.CreatePrincipal(principalRequestDTO),ApiMassage.SUCCESS);
        return apiResponse.getResponse(apiResponse);
    }

    @PutMapping(value = "/Update_Principal",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public ResponseEntity<String>Update_Principal(@RequestBody PrincipalRequestDto principalRequestDTO)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, principalService.UpdatePrincipal(principalRequestDTO),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

    @DeleteMapping(value ="/Delete_Principal",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public  ResponseEntity<String>Delete_Principal(@RequestParam Long principalId)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,principalService.DeletePrincipal(principalId),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }

    @GetMapping(value = "/Get_Principal_Details",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('Principal')")
    public  ResponseEntity<String>Get_Principal(@RequestParam Long principalId)throws JsonProcessingException{
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true,principalService.getPrincipalDetails(principalId),ApiMassage.SUCCESS);

        return apiResponse.getResponse(apiResponse);
    }
}