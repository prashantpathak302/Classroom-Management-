package com.classroom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Student_Detail")
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Student_Id")
    private Long StudentId;

    @Column(name = "Status_Flag")
    private Boolean StatusFlag;

    @Column(name = "Vacant_Flag")
    private Boolean VacantFlag;

    @Column(name = "StudentName")
    private String StudentName;

    @CreatedDate
    @Column(name = "Created_Date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "Last_Updated_Date")
    private Date LastUpdateDate;

    @Column(name = "Description")
    private String Discretion;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ClassRoomStudent> classRoomStudentMapping;

}
