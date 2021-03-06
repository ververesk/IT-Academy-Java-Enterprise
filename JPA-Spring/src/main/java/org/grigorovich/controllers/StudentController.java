package org.grigorovich.controllers;

import org.grigorovich.model.Course;
import org.grigorovich.model.Student;
import org.grigorovich.service.CourseService;
import org.grigorovich.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/*
Здесь прописана возможность прямо через вью менять с помощью many-to-many курсы студентов
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private CourseService serviceCourse;

    @RequestMapping("/allStudents")
    public String allStudents(Model model) { //модель нужна для того чтобы во вью можно было передать список работников
        List<Student> students = service.getAllStudents();
        model.addAttribute("allSt", students);
        return "all-students";
    }

    @RequestMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        List<Course> courses = serviceCourse.getAllCourses();
        model.addAttribute("courses", courses);
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-info";
    }

    @RequestMapping("/saveStudent")
    public String saveStudent(HttpServletRequest request, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-info";
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname =  request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            String username = request.getParameter("username");
            service.saveStudent(new Student(id, name, surname, age, username));
            return "redirect:/allStudents";
        }
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("stId") int id, Model model) { //получаем из запроса значение id
        Student student = service.getStudent(id);
        model.addAttribute("student", student); //теперь вью будет отбражаться с заполненными формами
        List<Course> courses = serviceCourse.getAllCourses();
        model.addAttribute("courses", courses);
        return "student-info";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("stId") int id) { //получаем из запроса значение id
        service.deleteStudent(id);
        return "redirect:/allStudents";
    }
}
