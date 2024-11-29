package com.classroom.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalRequestDto {

	
	private Long principalId;

	private String principalName;;
	
    private String principalShortName;
	
	private String Discretion;
	
  	private Boolean StatusFlag;
	
	private Boolean VacantFlag;


}
