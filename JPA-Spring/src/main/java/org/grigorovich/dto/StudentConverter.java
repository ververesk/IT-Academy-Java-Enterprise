package org.grigorovich.dto;

import org.grigorovich.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public StudentDTO entityToDto(Student student) {
        ModelMapper mapper = new ModelMapper();
        StudentDTO map = mapper.map(student, StudentDTO.class);
        return map;
    }

    public List<StudentDTO> entityToDto(List<Student> studentList) {
        return studentList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }


    public Student dtoToEntity(StudentDTO dto) {
        ModelMapper mapper = new ModelMapper();
        Student map = mapper.map(dto, Student.class);
        return map;
    }

    public List<Student> dtoToEntity(List<StudentDTO> dto) {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
