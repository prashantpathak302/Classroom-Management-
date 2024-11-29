package com.classroom.ServiceImpl;

import static io.micrometer.common.util.StringUtils.isBlank;

import com.classroom.entity.ClassRoom;
import com.classroom.entity.Teacher;
import com.classroom.entity.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.classroom.Dto.TeacherResponseDto;
import com.classroom.Dto.TimeTableRequestDto;
import com.classroom.Service.TimeTableService;
import com.classroom.api.structure.ApiMassage;

import com.classroom.excepction.BadExcepction;
import com.classroom.repository.ClassRoomRepository;
import com.classroom.repository.TeacherMasterRepository;
import com.classroom.repository.TimeTableRepository;


@Service
public class TimeTableServiceImpl implements TimeTableService {

	@Autowired
	private TimeTableRepository timeTableRepository;
	
	@Autowired
	private  TeacherMasterRepository teacherMasterRepository;
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	
//========================================Create Time-Table=================================================
    
    @Override
    public ResponseEntity<String> CreateTimeTable(TimeTableRequestDto  timeTableRequestDto) {

        TimeTable timeTable=TimeTable.builder()
        		
                .StartperiodTime(timeTableRequestDto.getStartperiodTime())
                .EndperiodTime(timeTableRequestDto.getEndperiodTime())
                .Subject(timeTableRequestDto.getSubject())
                .day(timeTableRequestDto.getDay())
                .TimeTableId(timeTableRequestDto.getTimeTableId())
                .build();

        Teacher teacherMaster=teacherMasterRepository.findById(timeTableRequestDto.getTeacherId())
        		.orElseThrow(() -> new BadExcepction(ApiMassage.TEACHER_NOT_FOUND));
        
 
        
        ClassRoom classroom= classRoomRepository.findById(timeTableRequestDto.getClassroomId())
        		.orElseThrow(() -> new BadExcepction(ApiMassage.CLASS_ROOM_NOT_FOUND));

        timeTable.setClassRoom(classroom);
        timeTable.setTeacher(teacherMaster);
        
        //Save time table Details
                   timeTableRepository.save(timeTable);


        return ResponseEntity.ok("TimeTable Created SuccessFully");
    }

    
//===========================================UpdateTime-Table================================================
    
    @Override
    public ResponseEntity<String> UpdatedTimeTable(TimeTableRequestDto  timeTableRequestDto) {
        TimeTable timeTable=timeTableRepository.findById(timeTableRequestDto.getTimeTableId())
                .orElseThrow(() -> new BadExcepction(ApiMassage.TIME_TABLE_NOT_FOUND));

        if (!isBlank (timeTableRequestDto.getSubject())){
          timeTable.setSubject(timeTableRequestDto.getSubject());
        }

        return ResponseEntity.ok("TimeTable Update SuccessFully");
    }

//===============================================Delete Time-Table==========================================
  
    @Override
    public ResponseEntity<String> DeleteTimeTable(Long TimeTableId) {
       TimeTable timeTable=timeTableRepository.findById(TimeTableId)
               .orElseThrow(() ->new BadExcepction(ApiMassage.TIME_TABLE_NOT_FOUND) );

       if (timeTable.getTimeTableId()==null ){
           throw new BadExcepction("TimeTable is Already Inactive");
       }
       timeTableRepository.deleteById(TimeTableId);
        return ResponseEntity.ok("TimeTable Deleted SuccessFully");
    }

//===========================================Get Time-Table================================================
    
    @Override
    public TeacherResponseDto getTimeTableDetails(Long TimeTableId) {
        TimeTable timeTable=timeTableRepository.findById(TimeTableId)
                .orElseThrow(() -> new BadExcepction(ApiMassage.TIME_TABLE_NOT_FOUND));


     TimeTable table= timeTableRepository.findById(TimeTableId)
    		 .orElseThrow(()-> new BadExcepction(ApiMassage.TIME_TABLE_NOT_FOUND));
	return null;

   
        
              
    }
}
