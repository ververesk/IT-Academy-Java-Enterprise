package org.grigorovich.dto;

import org.grigorovich.model.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherConverter {
    public TeacherDTO entityToDto(Teacher teacher) {
        ModelMapper mapper = new ModelMapper();
        TeacherDTO map = mapper.map(teacher, TeacherDTO.class);
        return map;
    }

    public List<TeacherDTO> entityToDto(List<Teacher> teacherList) {
        return teacherList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }


    public Teacher dtoToEntity(TeacherDTO dto) {
        ModelMapper mapper = new ModelMapper();
        Teacher map = mapper.map(dto, Teacher.class);
        return map;
    }

    public List<Teacher> dtoToEntity(List<TeacherDTO> dto) {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
