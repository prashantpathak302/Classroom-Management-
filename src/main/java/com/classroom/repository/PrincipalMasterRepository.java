package com.classroom.repository;


import com.classroom.entity.Principal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrincipalMasterRepository extends JpaRepository<Principal,Long> {

	

}
