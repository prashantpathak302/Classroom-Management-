package com.classroom.ServiceImpl;

import com.classroom.Dto.UpdateClassroomRequestDto;
import com.classroom.entity.*;
import com.classroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.ClassRoomRequestDTO;
import com.classroom.Dto.ClassRoomResponseDTO;
import com.classroom.Service.ClassRoomService;
import com.classroom.api.structure.ApiMassage;
import com.classroom.excepction.BadExcepction;
import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
	@Autowired
	private ClassRoomRepository classRoomRepository;

	@Autowired
	ClassRoomStudentMasterMpgRepository classRoomStudentMasterMpgRepository;

	@Autowired
	private StudentMasterRepository studentMasterRepository;
	@Autowired
	private TeacherMasterRepository teacherMasterRepository;
	@Autowired
	private PrincipalMasterRepository principalMasterRepository;

	// ---------------------------------------------CreateClassRoom------------------------------------------------------

	@Override
	public ResponseEntity<String> CreateClassRoom(ClassRoomRequestDTO classRoomRequestDTO) {

		if (classRoomRequestDTO.getPrincipalId() != null) {
			principalMasterRepository.findById(classRoomRequestDTO.getPrincipalId())
					.orElseThrow(() -> new BadExcepction(ApiMassage.PRINCIPAL_NOT_FOUND));
		}

		else if (classRoomRequestDTO.getTeacherId() != null) {
			teacherMasterRepository.findById(classRoomRequestDTO.getTeacherId())
					.orElseThrow(() -> new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));
		}

		else if (classRoomRequestDTO.getStudentIds()!= null &&!classRoomRequestDTO.getStudentIds().isEmpty()) {

		  for (Long StudentId : classRoomRequestDTO.getStudentIds()) {
		  studentMasterRepository.findById(StudentId) .orElseThrow(() -> new
		  BadExcepction(ApiMassage.STUDENT_NOT_FOUND));

		  } }


		ClassRoom classRoom = ClassRoom.builder()
				.VacantFlag(classRoomRequestDTO.getVacantFlag())
				.StatusFlag(true)
				.StartTime(classRoomRequestDTO.getStartTime())
				.EndTime(classRoomRequestDTO.getEndTime())
				.ClassName(classRoomRequestDTO.getClassName())
				.days(classRoomRequestDTO.getDays())
				.Subject(classRoomRequestDTO.getSubject())
				.build();


	//Set Teacher Master Details

		Teacher teacherMaster =teacherMasterRepository.findById(classRoomRequestDTO.getTeacherId())
		                   .orElseThrow(() -> new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));
		   classRoom.setTeacher(teacherMaster);

	//Set Principal Master Details

		   Principal principalMaster=principalMasterRepository.findById(classRoomRequestDTO.getPrincipalId())
				  .orElseThrow(() -> new BadExcepction(ApiMassage.PRINCIPAL_NOT_FOUND) );
		   classRoom.setPrincipal(principalMaster);


		if (classRoomRequestDTO.getStudentIds() != null && !classRoomRequestDTO.getStudentIds().isEmpty()) {
           for (Long StudentId:classRoomRequestDTO.getStudentIds()) {

			   Student studentMaster = studentMasterRepository.findById(StudentId)
					   .orElseThrow(() -> new BadExcepction(ApiMassage.STUDENT_NOT_FOUND));

			   studentMasterRepository.save(studentMaster);

			   ClassRoomStudent classRoomStudentMasterMpg = ClassRoomStudent.builder()
					   .student(studentMaster)
					   .classRoom(classRoom)
					   .build();

			   classRoomStudentMasterMpgRepository.save(classRoomStudentMasterMpg);

		   }
		}


		classRoomRepository.save(classRoom);
		return ResponseEntity.ok("ClassRoom Created Successfully");

	}


	

// ============================================UpdateClassRoom===================================================

	@Override
	public ResponseEntity<String> UpdateClassRoom(UpdateClassroomRequestDto updateClassroomRequestDto) {

		if (updateClassroomRequestDto.getClassroomId() != null) {

			classRoomRepository.findById(updateClassroomRequestDto.getClassroomId())
					.orElseThrow(() -> new BadExcepction(ApiMassage.CLASS_ROOM_NOT_FOUND));
		} else if (updateClassroomRequestDto.getPrincipalId() != null) {
			principalMasterRepository.findById(updateClassroomRequestDto.getPrincipalId())
					.orElseThrow(() -> new BadExcepction(ApiMassage.PRINCIPAL_NOT_FOUND));
		}
		
		ClassRoom  classroom =new ClassRoom();
		
		if (!isBlank(updateClassroomRequestDto.getClassName())) {
			

		}
		// Remove Teacher Id

		if (updateClassroomRequestDto.getNewTeacherId() != null) {
			Teacher teacherMaster = teacherMasterRepository.findById(updateClassroomRequestDto.getNewTeacherId())
					.orElseThrow(() -> new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));

			teacherMasterRepository.save(teacherMaster);
			// classRoomRepository.save(classRoom);
		}


		// Remove StudentId
		if (updateClassroomRequestDto.getRemovedStudentIds() != null && !updateClassroomRequestDto.getRemovedStudentIds().isEmpty()) {

			for (Long StudentId : updateClassroomRequestDto.getRemovedStudentIds()) {
				Student studentMaster = studentMasterRepository.findById(StudentId)
						.orElseThrow(() -> new BadExcepction(ApiMassage.STUDENT_NOT_FOUND));
				
			

				ClassRoomStudent classRoomStudentMasterMpg=classRoomStudentMasterMpgRepository.FindByClassroomIdStudentId(studentMaster.getStudentId(), classroom.getClassroomId());
				if(classRoomStudentMasterMpg!=null)
					classRoomStudentMasterMpgRepository.delete(classRoomStudentMasterMpg);
			}
		}

//Add new StudentId
		if (updateClassroomRequestDto.getNewStudentIds() != null && !updateClassroomRequestDto.getNewStudentIds().isEmpty()) {
			for (Long StudentId : updateClassroomRequestDto.getNewStudentIds()) {

				Student studentMaster = studentMasterRepository.findById(StudentId)
						.orElseThrow(() -> new BadExcepction(ApiMassage.STUDENT_NOT_FOUND));

				studentMasterRepository.save(studentMaster);

				ClassRoom classroom1 = new ClassRoom();
				ClassRoomStudent classRoomStudentMasterMpg = ClassRoomStudent.builder()
						.student(studentMaster)
						.classRoom(classroom1)
						.build();

				classRoomStudentMasterMpgRepository.save(classRoomStudentMasterMpg);

			}
		}
		return ResponseEntity.ok("ClassRoom Updated Successfully");
	}



//========================================GetClassRoomDetails=============================================


	@Override
	public ResponseEntity<ClassRoomResponseDTO> getClassRoomDetails(Long ClassroomId) {

		ClassRoom classRoom = classRoomRepository.findById(ClassroomId)
				.orElseThrow(() -> new BadExcepction(ApiMassage.CLASS_ROOM_NOT_FOUND));

		ClassRoomResponseDTO classRoomResponseDTO = new ClassRoomResponseDTO();

		classRoomResponseDTO.setClassroomId(classRoom.getClassroomId());
		classRoomResponseDTO.setClassName(classRoom.getClassName());
		classRoomResponseDTO.setDays(classRoom.getDays());
		classRoomResponseDTO.setPrincipalId(classRoom.getPrincipal().getPrincipalId());
		classRoomResponseDTO.setStatusFlag(classRoom.getStatusFlag());
		classRoomResponseDTO.setVacantFlag(classRoom.getVacantFlag());
		classRoomResponseDTO.setStartTime(classRoom.getStartTime());
		classRoomResponseDTO.setEndTime(classRoom.getEndTime());
		classRoomResponseDTO.setTeacherId(classRoom.getTeacher().getTeacherId());
		// classRoomResponseDTO.setStudentId(classRoom.getStudentId());

		return new ResponseEntity<>(classRoomResponseDTO, HttpStatus.OK);
	}


	//=========================================DeleteClassRoom============================================


	@Override
	public ResponseEntity<String> DeleteClassRoom(Long ClassroomId) {

		ClassRoom classRoom = classRoomRepository.findById(ClassroomId)
				.orElseThrow(() -> new BadExcepction(ApiMassage.CLASS_ROOM_NOT_FOUND));

		if (!classRoom.getStatusFlag()) {
			throw new BadExcepction("ClassRoom is Already InActive");
		}

		classRoomRepository.delete(classRoom);
		return ResponseEntity.ok("ClassRoom Deleted Successfully");
	}

}
