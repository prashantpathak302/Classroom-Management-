package com.classroom.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTable {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
    @Column(name = "Time_Table_Id")
    private Long TimeTableId;

    @Column(name = "Subject")
    private String Subject ;

    @Column(name = "Start_Period_time")
    private LocalTime StartperiodTime;


    @Column(name = "End_Period_time")
    private LocalTime EndperiodTime;

@Column(name = "Day")
    private String day;

@OneToOne
@JoinColumn(name = "Teacher_Id",referencedColumnName = "Teacher_Id")
private Teacher teacher;

@OneToOne
@JoinColumn(name = "Class_Id",referencedColumnName = "Class_Id")
    private ClassRoom classRoom;
}
