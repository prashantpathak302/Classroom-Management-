package com.classroom.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UpdateClassroomRequestDto {
    private Long ClassroomId;

    private LocalTime StartTime;

    private  Long NewTeacherId;

    private LocalTime EndTime;

    private List<DayOfWeek> days;

    private Long principalId;

    private Boolean StatusFlag;

    private Boolean VacantFlag;

    private List<Long>newStudentIds;
    private Long StudentId;

    private List<Long>RemovedStudentIds;

    private String ClassName;
}
