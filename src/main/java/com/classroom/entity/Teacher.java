package com.classroom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Teacher_Details")
public class Teacher {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Teacher_Id")
    private Long TeacherId;

    @Column(name = "Teacher_name")
    private String TeacherName;

    @Column(name = "Role")
    private  String Role;

    @Column(name = "Discretion")
    private String Discretion;

    @Column(name = "Status_Flag")
    private Boolean StatusFlag;

    @Column(name="Vacant_Flag")
    private Boolean VacantFlag;

    @CreatedDate()
    @Column(name = "Created_Date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "Last_Update_Date")
    private Date LastUpdateDate;

    @OneToOne(mappedBy = "teacher",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private  ClassRoom classRoom;




}
