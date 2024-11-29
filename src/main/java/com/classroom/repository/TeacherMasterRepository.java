package com.classroom.repository;



import com.classroom.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherMasterRepository extends JpaRepository<Teacher,Long> {

}
