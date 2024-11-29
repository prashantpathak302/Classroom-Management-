package com.classroom.repository;



import com.classroom.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentMasterRepository extends JpaRepository<Student,Long>{



}
