package com.classroom.ServiceImpl;


import com.classroom.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.classroom.Dto.StudentRequestDto;
import com.classroom.Dto.StudentResponseDto;
import com.classroom.Service.StudentService;
import com.classroom.api.structure.ApiMassage;
import com.classroom.excepction.BadExcepction;
import com.classroom.repository.StudentMasterRepository;
import static io.micrometer.common.util.StringUtils.isBlank;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentMasterRepository studentMasterRepository;
	
//=========================================CreateStudent====================================================	
	
	@Override
	public ResponseEntity<String> CreateStudent(StudentRequestDto studentRequestDto) {

	Student studentMaster=Student.builder()
			.StatusFlag(studentRequestDto.getStatusFlag())
			.VacantFlag(studentRequestDto.getVacantFlag())
			.StatusFlag(true)
			.VacantFlag(false)
			.StudentName(studentRequestDto.getStudentName())
			.Discretion(studentRequestDto.getDiscretion())
				.build();
		
		//Save to Student Master details
		studentMasterRepository.save(studentMaster);
		return ResponseEntity.ok("Student Created Successfully");

	}
	
//===========================================DeleteStudent==================================================
	
	@Override
	public ResponseEntity<String> DeleteStudent(Long StudentId) {
		
		Student studentMaster=studentMasterRepository.findById(StudentId)
				.orElseThrow(()->  new BadExcepction(ApiMassage.STUDENT_NOT_FOUND));
		
		
		if (!studentMaster.getStatusFlag()) {
			throw new BadExcepction("Student Allready inactive");
		}
		studentMasterRepository.deleteById(StudentId);
		return ResponseEntity.ok("Student DisActive Successfully");
	}

//============================================UpdateStudent==================================================	
	
	@Override
	public ResponseEntity<String> UpdateStudent(StudentRequestDto studentRequestDto) {

		Student studentMaster=studentMasterRepository.findById(studentRequestDto.getStudentId())
				.orElseThrow(()->  new BadExcepction(ApiMassage.STUDENT_NOT_FOUND));
		


		if (!isBlank(studentMaster.getStudentName())) {
			studentMaster.setStudentName(studentRequestDto.getStudentName());
		}

		
		if (!isBlank(studentMaster.getDiscretion())) {
			studentMaster.setDiscretion(studentRequestDto.getDiscretion());
		}

	
		studentMasterRepository.save(studentMaster);
		return ResponseEntity.ok("Student Updated Successfully ");
	}

//==========================================GetStudentDetails==================================================	
	
	@Override
	public StudentResponseDto getStudentDetails(Long StudentId) {
		

		Student studentMaster=studentMasterRepository.findById(StudentId)
				.orElseThrow(()->  new BadExcepction(ApiMassage.STUDENT_NOT_FOUND));
		
		return StudentResponseDto.builder()
				.StudentId(studentMaster.getStudentId())
				.StatusFlag(studentMaster.getStatusFlag())
				.VacantFlag(studentMaster.getVacantFlag())
				.createdDate(studentMaster.getCreatedDate())
				.LastUpdateDate(studentMaster.getLastUpdateDate())
				.StudentName(studentMaster.getStudentName())

				.Discretion(studentMaster.getDiscretion())
              .build();
	}

	
}
