package org.grigorovich.JSONControllers;

import org.grigorovich.dto.CourseConverter;
import org.grigorovich.dto.CourseDTO;
import org.grigorovich.dto.TeacherConverter;
import org.grigorovich.dto.TeacherDTO;
import org.grigorovich.exception.NoSuchEntityException;
import org.grigorovich.model.Course;
import org.grigorovich.model.Teacher;
import org.grigorovich.service.CourseService;
import org.grigorovich.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/", produces = "application/json")
@PreAuthorize("hasAnyRole('ADMIN')")
public class TeacherJsonController {
    @Autowired
    private TeacherService service;

    @Autowired
    private CourseService courseService;

    @Autowired
    TeacherConverter teacherConverter;

    @Autowired
    CourseConverter courseConverter;


    @GetMapping("/teachers")
    public List<TeacherDTO> showAllTeachers() {
        List<Teacher> allTeachers = service.getAllTeachers();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher t : allTeachers) {
            Course course = t.getCourse();
            TeacherDTO teacherDTO = teacherConverter.entityToDto(t);
            teacherDTO.setCourseDTO(courseConverter.entityToDto(course));
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }

    @GetMapping("/teachers/{id}")
    public TeacherDTO getTeacher(@PathVariable int id) {
        Teacher teacher = service.getTeacher(id);
        Course course = teacher.getCourse();
        TeacherDTO teacherDTO = teacherConverter.entityToDto(teacher);
        if (teacherDTO == null) {
            throw new NoSuchEntityException("There is no Entity with id=" + id + " in DataBase");
        }
        teacherDTO.setCourseDTO(courseConverter.entityToDto(course));
        return teacherDTO;
    }

    @PostMapping("/teachers")
    public TeacherDTO addNewTeacher(@RequestBody TeacherDTO dto) {
        Teacher teacher = teacherConverter.dtoToEntity(dto);
        service.saveTeacher(teacher);
        TeacherDTO teacherDTO = teacherConverter.entityToDto(teacher);
        return teacherDTO;
    }

    @PutMapping("/teachers")
    public TeacherDTO updateTeacher(@RequestBody TeacherDTO dto) {
        CourseDTO courseDTO = dto.getCourseDTO();
        Course course = courseConverter.dtoToEntity(courseDTO);
        Teacher teacher = teacherConverter.dtoToEntity(dto);
        service.saveTeacher(teacher);
        courseService.saveCourse(course);
        TeacherDTO teacherDTO = teacherConverter.entityToDto(teacher);
        if(course!=null) {
            teacherDTO.setCourseDTO(courseConverter.entityToDto(course));
        } else {
            teacherDTO.setCourseDTO(null);
        }
        return teacherDTO;
    }

    @DeleteMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable int id) {
        Teacher teacher = service.getTeacher(id);
        if (teacher == null) {
            throw new NoSuchEntityException("There is no entity with id=" + id + " in DataBase");
        }
        service.deleteTeacher(id);
        return "Entity with id=" + id + " was deleted";
    }

    @GetMapping("/sum")
    public Long sumSalariesOfTeachers() {
        return service.sumTeacherSalary();
    }

    @GetMapping("/average")
    public Double avgSalariesOfTeachers() {
        return service.avgTeacherSalary();
    }
}
