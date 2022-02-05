package org.grigorovich.dto;

import org.grigorovich.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {
    public CourseDTO entityToDto(Course course) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(course, CourseDTO.class);
    }

    public List<CourseDTO> entityToDto(List<Course> courseList) {
        return courseList.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    public Course dtoToEntity(CourseDTO dto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Course.class);
    }

    public List<Course> dtoToEntity(List<CourseDTO> dto) {
        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
