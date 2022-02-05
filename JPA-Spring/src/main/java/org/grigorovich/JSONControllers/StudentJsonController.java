package org.grigorovich.JSONControllers;

import org.grigorovich.dto.CourseConverter;
import org.grigorovich.dto.CourseDTO;
import org.grigorovich.dto.StudentConverter;
import org.grigorovich.dto.StudentDTO;
import org.grigorovich.exception.NoSuchEntityException;
import org.grigorovich.model.Course;
import org.grigorovich.model.Student;
import org.grigorovich.service.CourseService;
import org.grigorovich.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/", produces = "application/json")
public class StudentJsonController {
    @Autowired
    private StudentService service;

    @Autowired
    private CourseService courseService;

    @Autowired
    StudentConverter studentConverter;

    @Autowired
    CourseConverter courseConverter;


    @GetMapping("/students")
    public List<StudentDTO> showAllStudents() {
        List<Student> allStudents = service.getAllStudents();
        return studentConverter.entityToDto(allStudents);

    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable int id) {
        Student student = service.getStudent(id);
        List<Course> courses = student.getCourseList();
        StudentDTO studentDTO = studentConverter.entityToDto(student);
        if (studentDTO == null) {
            throw new NoSuchEntityException("There is no Entity with id=" + id + " in DataBase");
        }
        studentDTO.setCourseDTO(courseConverter.entityToDto(courses));
        return studentDTO;
    }


    @PostMapping("/students")
    public StudentDTO addNewStudent(@RequestBody StudentDTO dto) {
        Student student = studentConverter.dtoToEntity(dto);
        service.saveStudent(student);
        StudentDTO studentDTO = studentConverter.entityToDto(student);
        return studentDTO;
    }

    @PutMapping("/students")
    public StudentDTO updateStudent(@RequestBody StudentDTO dto) {
        List<CourseDTO> courseDTO = dto.getCourseDTO();
        List<Course> courseList = courseConverter.dtoToEntity(courseDTO);
        Student student = studentConverter.dtoToEntity(dto);
        service.saveStudent(student);
        courseService.saveAllCourses(courseList);
        StudentDTO studentDTO = studentConverter.entityToDto(student);
        studentDTO.setCourseDTO(courseDTO);
        return studentDTO;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = service.getStudent(id);
        if (student == null) {
            throw new NoSuchEntityException("There is no entity with id=" + id + " in DataBase");
        }
        service.deleteStudent(id);
        return "Entity with id=" + id + " was deleted";
    }
}
