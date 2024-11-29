package com.classroom.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.PrincipalRequestDto;
import com.classroom.Dto.PrincipalResponseDTO;





public interface PrincipalService  {

	ResponseEntity<String> CreatePrincipal(PrincipalRequestDto principalrequestdto );
	ResponseEntity<String>DeletePrincipal(Long principalId);
	ResponseEntity<String>UpdatePrincipal(PrincipalRequestDto principalRequestDto);
	PrincipalResponseDTO getPrincipalDetails(Long principalId);
}
