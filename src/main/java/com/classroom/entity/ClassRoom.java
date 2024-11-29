package com.classroom.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.security.auth.Subject;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Class_Id")
    private Long ClassroomId;

    @Column(name = "Start_time")
    private LocalTime StartTime;

    @Column(name = "End_Time")
    private LocalTime EndTime;

    private List<DayOfWeek> days;

    @Column(name = "Status_Flag")
    private Boolean StatusFlag;

    @Column(name = "Vacant_Flag")
    private Boolean VacantFlag;

    @Column(name = "Subject")
    private String Subject;



    @Column(name = "Class_Name")
    private String ClassName;

    @OneToOne
    @JoinColumn(name = "principal_Id",referencedColumnName ="principal_Id")
    private Principal principal;

   @OneToMany(mappedBy = "classRoom",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ClassRoomStudent> classRoomStudentMapping;

    @OneToOne
    @JoinColumn(name = "Teacher_Id",referencedColumnName = "Teacher_Id")
    private Teacher teacher;

    @OneToOne(mappedBy = "classRoom")
    private  TimeTable timeTable;
}




