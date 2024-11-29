package com.classroom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "Principal_Details")
public class Principal {
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Id
   @Column(name = "principal_Id")
    private Long principalId;

   @Column(name = "principal_Name")
    private String principalName;

    @Column(name = "Discretion")
    private String Discretion;

    @CreatedDate
    @Column(name ="created_Date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "Last_Update_Date")
    private Date LastUpdateDate;

    @Column(name = "Status_Flag")
    private Boolean StatusFlag;

    @Column(name = "Vacant_Flag")
    private Boolean VacantFlag;

    @OneToOne(mappedBy = "principal",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private ClassRoom classRoom;
}
