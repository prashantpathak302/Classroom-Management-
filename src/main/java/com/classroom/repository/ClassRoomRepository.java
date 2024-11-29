package com.classroom.repository;



import com.classroom.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Long>{

}
