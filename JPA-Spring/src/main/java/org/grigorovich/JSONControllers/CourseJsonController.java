package org.grigorovich.JSONControllers;

import org.grigorovich.exception.NoSuchEntityException;
import org.grigorovich.model.Course;
import org.grigorovich.service.CourseService;
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
public class CourseJsonController {
    @Autowired
    private CourseService service;

    @GetMapping("/courses")
    public List<Course> showAllCourse() {
        List<Course> allCourses = service.getAllCourses();
        return allCourses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id) {
        Course course = service.getCourse(id);
        if (course == null) {
            throw new NoSuchEntityException("There is no Entity with id=" + id + " in DataBase");
        }
        return course;
    }

    @PostMapping("/courses")
    public Course addNewCourse(@RequestBody Course course) {
        service.saveCourse(course);
        return course;
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        service.saveCourse(course);
        return course;
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {
        Course course = (Course) service.getCourse(id);
        if (course == null) {
            throw new NoSuchEntityException("There is no entity with id=" + id + " in DataBase");
        }
        service.deleteCourse(id);
        return "Entity with id=" + id + " was deleted";
    }
}