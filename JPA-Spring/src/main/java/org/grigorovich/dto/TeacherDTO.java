package org.grigorovich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TeacherDTO {
    private int id;
    private String name;
    private String surname;
    private int salary;
    @JsonProperty("course")
    private CourseDTO courseDTO;
    private String username;
}
