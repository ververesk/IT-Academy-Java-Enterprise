package org.grigorovich.app.JSONControllers;

import org.grigorovich.app.exception.NoSuchEntityException;
import org.grigorovich.app.service.EntityService;
import org.grigorovich.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("studentServiceImpl")
    private EntityService service;

    @GetMapping("/students")
    public List<Student> showAllStudents() {
        List<Student> allStudents = service.getAll();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = (Student) service.getEntity(id);
        if (student == null) {
            throw new NoSuchEntityException("There is no Entity with id=" + id + " in DataBase");
        }
        return student;
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        service.saveEntity(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        service.saveEntity(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = (Student) service.getEntity(id);
        if (student == null) {
            throw new NoSuchEntityException("There is no entity with id=" + id + " in DataBase");
        }
        service.deleteEntity(id);
        return "Entity with id=" + id + " was deleted";
    }
}
