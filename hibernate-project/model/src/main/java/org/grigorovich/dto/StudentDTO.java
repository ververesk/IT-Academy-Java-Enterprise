package org.grigorovich.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String username;
}
