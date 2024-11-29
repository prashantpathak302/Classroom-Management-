package com.classroom.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@Table(name = "ClassRoom_Student")
public class ClassRoomStudent {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
    @Column(name = "CSID")
    private Long CSID;

    @ManyToOne
    @JoinColumn(name = "Student_Id",referencedColumnName = "Student_Id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Class_Id",referencedColumnName = "Class_Id")
    private ClassRoom classRoom;



}
