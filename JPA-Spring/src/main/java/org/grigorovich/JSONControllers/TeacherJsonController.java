package org.grigorovich.JSONControllers;

import org.grigorovich.exception.NoSuchEntityException;
import org.grigorovich.model.Teacher;
import org.grigorovich.service.TeacherService;
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
public class TeacherJsonController {
    @Autowired
    private TeacherService service;

    @GetMapping("/teachers")
    public List<Teacher> showAllTeachers() {
        List<Teacher> allTeachers = service.getAllTeachers();
        return allTeachers;
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        Teacher teacher = service.getTeacher(id);
        if (teacher == null) {
            throw new NoSuchEntityException("There is no Entity with id=" + id + " in DataBase");
        }
        return teacher;
    }

    @PostMapping("/teachers")
    public Teacher addNewTeacher(@RequestBody Teacher teacher) {
        service.saveTeacher(teacher);
        return teacher;
    }

    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        service.saveTeacher(teacher);
        return teacher;
    }

    @DeleteMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable int id) {
        Teacher teacher = (Teacher) service.getTeacher(id);
        if (teacher == null) {
            throw new NoSuchEntityException("There is no entity with id=" + id + " in DataBase");
        }
        service.deleteTeacher(id);
        return "Entity with id=" + id + " was deleted";
    }
}
