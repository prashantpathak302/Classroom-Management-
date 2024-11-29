package com.classroom.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PrincipalResponseDTO {

	private Long principalId;
	
	
	private String principalName;
	
    private String principalShortName;
	
	private String Discretion;

	private Date createdDate;

    private Date LastUpdateDate;
	
  	private Boolean StatusFlag;
	
	private Boolean VacantFlag;
}
