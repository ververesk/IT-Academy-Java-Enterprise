package org.grigorovich.app.controllers;

import org.grigorovich.app.service.EntityService;
import org.grigorovich.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    @Qualifier("courseServiceImpl")
    private EntityService service;

    @RequestMapping("/allCourses")
    public String allCourses(Model model) {
        List<Course> courses = service.getAll();
        model.addAttribute("courses", courses);
        return "all-courses";
    }

    @RequestMapping("/addNewCourse")
    public String addNewCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course-info";
    }

    @RequestMapping("/saveCourse")
    public String saveCourse(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "course-info";
        } else {
            service.saveEntity(course);
            return "redirect:/allCourses";
        }
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(@RequestParam("cId") int id, Model model) {
        Course course = (Course) service.getEntity(id);
        model.addAttribute("course", course);
        return "course-info";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("cId") int id) {
        service.deleteEntity(id);
        return "redirect:/allCourses";
    }
}
