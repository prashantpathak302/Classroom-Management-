package com.classroom.repository;



import com.classroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMasterRepository extends JpaRepository<User,Long> {

}
