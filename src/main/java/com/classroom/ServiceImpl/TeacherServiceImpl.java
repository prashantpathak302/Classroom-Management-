package com.classroom.ServiceImpl;


import com.classroom.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.classroom.Dto.TeacherRequestDTO;
import com.classroom.Dto.TeacherResponseDto;
import com.classroom.Service.TeacherService;
import com.classroom.api.structure.ApiMassage;

import com.classroom.excepction.BadExcepction;
import com.classroom.repository.ClassRoomRepository;
import com.classroom.repository.TeacherMasterRepository;
import com.classroom.repository.TimeTableRepository;

import static io.micrometer.common.util.StringUtils.isBlank;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    @Autowired
    private TeacherMasterRepository teacherMasterRepository;
    
    @Autowired
     private ClassRoomRepository classRoomRepository;

    
    
//=============================================CreateTeacher================================================

    @Override
    public ResponseEntity<String> CreateTeacher(TeacherRequestDTO teacherRequestDTO) {

        Teacher teacherMaster=Teacher.builder()
                .StatusFlag(teacherRequestDTO.getStatusFlag())
                .VacantFlag(teacherRequestDTO.getVacantFlag())
                .StatusFlag(true)
                .VacantFlag(false)
                .TeacherId(teacherRequestDTO.getTeacherName())
                .Discretion(teacherRequestDTO.getDiscretion())
                .build();
        //Save Teacher Master
        teacherMasterRepository.save(teacherMaster);
       
        return ResponseEntity.ok("Teacher Created Successfully");
    }

//============================================UpdateTeacher=================================================
    
    @Override
    public ResponseEntity<String> UpdateTeacher(TeacherRequestDTO teacherRequestDTO) {

       Teacher teacherMaster=teacherMasterRepository.findById(teacherRequestDTO.getTeacherId())
               .orElseThrow(() -> new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));


        if (!isBlank (teacherRequestDTO.getTeacherName())){
            teacherMaster.setTeacherName(teacherMaster.getTeacherName());
        }

        if (!isBlank(teacherRequestDTO.getDiscretion())){
            teacherMaster.setDiscretion(teacherMaster.getDiscretion());
        }

        teacherMasterRepository.save(teacherMaster);
        return ResponseEntity.ok("Update Teacher Details SuccessFully");
    }

    
//========================================== Delete Teacher ================================================
   
    @Override
    public ResponseEntity<String> DeleteTeacher(Long TeacherId) {

        Teacher teacherMaster=teacherMasterRepository.findById(TeacherId)
                .orElseThrow(()->new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));
        
        if (!teacherMaster.getStatusFlag()){
          throw new BadExcepction("Teacher Details are Allready Inactive");
        }
        
        teacherMasterRepository.deleteById(TeacherId);
    return ResponseEntity.ok(" Teacher Details are DisActive SucessFully ");
    }

    
//=========================================Get Teacher Details==============================================
   
    @Override
    public TeacherResponseDto GetTeacherDetails(Long TeacherId) {

        Teacher teacherMaster=teacherMasterRepository.findById(TeacherId)
                .orElseThrow(()->new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));

    return TeacherResponseDto.builder()
                .TeacherId(teacherMaster.getTeacherId())
                .StatusFlag(teacherMaster.getStatusFlag())
                .VacantFlag(teacherMaster.getVacantFlag())
                .createdDate(teacherMaster.getCreatedDate())
                .LastUpdateDate(teacherMaster.getLastUpdateDate())
                .teacherName(teacherMaster.getTeacherName())
                .Discretion(teacherMaster.getDiscretion())
                .build();
    }


}
