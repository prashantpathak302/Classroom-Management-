package com.classroom.ServiceImpl;


import com.classroom.entity.Principal;
import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.PrincipalRequestDto;
import com.classroom.Dto.PrincipalResponseDTO;
import com.classroom.Service.PrincipalService;
import com.classroom.api.structure.ApiMassage;

import com.classroom.excepction.BadExcepction;

import com.classroom.repository.PrincipalMasterRepository;

import static org.apache.logging.log4j.util.Strings.isBlank;


@Service
public class PrincipalServiceImpl implements PrincipalService {
	
@Autowired
private PrincipalMasterRepository principalMasterRepository;


//==========================================CreatePrincipal=================================================

  @Override
  public ResponseEntity<String> CreatePrincipal(PrincipalRequestDto principalrequestdto) {
	
	Principal principalMaster= Principal.builder()
			
			.StatusFlag(principalrequestdto.getStatusFlag())
			.VacantFlag(principalrequestdto.getVacantFlag())
			.StatusFlag(true)
			.VacantFlag(false)

			.Discretion(principalrequestdto.getDiscretion())
			.principalName(principalrequestdto.getPrincipalName())
            .build();
	       principalMasterRepository.save(principalMaster);

	
	return ResponseEntity.ok("principal created Successfully");
}

//===========================================DeletePrincipal===============================================

	@Override
	public ResponseEntity<String> DeletePrincipal(Long principalId) {
		
	Principal principalMaster=principalMasterRepository.findById(principalId)
			.orElseThrow(()->new BadExcepction(ApiMassage.PRINCIPAL_NOT_FOUND));
	
	if (!principalMaster.getStatusFlag()) {
		throw new BadExcepction("Principal is allready inactive");
	}
		
		principalMasterRepository.deleteById(principalId);
		return ResponseEntity.ok("Principal is disactive Successfully ");
	}

//===========================================UpdatePrincipal================================================

	@Override
	public ResponseEntity<String> UpdatePrincipal(PrincipalRequestDto principalRequestDto) {
		
		Principal principalMaster=principalMasterRepository.findById(principalRequestDto.getPrincipalId())
				.orElseThrow(()->new BadExcepction(ApiMassage.PRINCIPAL_NOT_FOUND));
	
	
		if(!isBlank(principalRequestDto.getPrincipalName())) {
	      principalMaster.setPrincipalName(principalRequestDto.getPrincipalName());
		
		}
		

	
		if (!isBlank(principalRequestDto.getDiscretion())) {
			
			principalMaster.setDiscretion(principalRequestDto.getDiscretion());
		}
		
		principalMasterRepository.save(principalMaster);
		
		
		return ResponseEntity.ok("Principal Updated Successfully");
	}

//=======================================GetPrincipalDetails================================================
	
	@Override
	public PrincipalResponseDTO getPrincipalDetails(Long principalId) {
		
		Principal principalMaster=principalMasterRepository.findById(principalId)
				.orElseThrow(()->new BadExcepction (ApiMassage.PRINCIPAL_NOT_FOUND));
		
		return PrincipalResponseDTO.builder()
				.principalId(principalMaster.getPrincipalId())
				.principalName(principalMaster.getPrincipalName())

				.Discretion(principalMaster.getDiscretion())
				.StatusFlag(principalMaster.getStatusFlag())
				.LastUpdateDate(principalMaster.getLastUpdateDate())
				.createdDate(principalMaster.getCreatedDate())
				.VacantFlag(principalMaster.getVacantFlag())
				.build();
	
	}

}
