package com.classroom.repository;

import com.classroom.entity.ClassRoomStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassRoomStudentMasterMpgRepository extends JpaRepository<ClassRoomStudent,Long> {

	@Query(value = "Select * from  classroom_student_mpg where class_Id=?1 and Student_Id=?2",nativeQuery = true)
	public ClassRoomStudent FindByClassroomIdStudentId(Long classroomId,Long StudentId);
}
