package org.grigorovich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class StudentDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    @JsonProperty("course")
    private List<CourseDTO> courseDTO;
    private String username;
}

