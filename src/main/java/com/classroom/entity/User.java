package com.classroom.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name="User_Details")
public class User {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
    @Column(name = "User_Id")
    private Integer userId;

    @Column(name = "user_name")
    private  String User_Name;

    @Column(name = "Password")
    private  String Password;

}
