package org.grigorovich.controllers;


import org.grigorovich.model.Teacher;
import org.grigorovich.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class TeacherController {
    private static final Logger logger = LoggerFactory.getLogger(
            TeacherController.class);

    @Autowired
    private TeacherService service;


    @RequestMapping("/allTeachers")
    public String allTeachers(Model model) {
        List<Teacher> teachers = service.getAllTeachers();
        model.addAttribute("allTeach", teachers);
        return "all-teachers";
    }

    @RequestMapping("/addNewTeacher")
    public String addNewTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher-info";
    }

    @RequestMapping("/saveTeacher")
    public String saveTeacher(HttpServletRequest request, @Valid @ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teacher-info";
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname =  request.getParameter("surname");
            int salary = Integer.parseInt(request.getParameter("salary"));
            String username = request.getParameter("username");
            service.saveOrUpdateTeacher(new Teacher(id, name, surname, salary, username));
            return "redirect:/allTeachers";
        }
    }

    @RequestMapping("/updateTeacher")
    public String updateTeacher(@RequestParam("tId") int id, Model model) {
        Teacher teacher = service.getTeacher(id);
        model.addAttribute("teacher", teacher);
        return "teacher-info";
    }

    @RequestMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("tId") int id) { //получаем из запроса значение id
        service.deleteTeacher(id);
        return "redirect:/allTeachers";
    }

    @RequestMapping("/avgTeacherSalary")
    public String avgSalary(Model model) {
        Double avgSalaries = service.avgTeacherSalary();
        String format = String.format("%.2f", avgSalaries);
        model.addAttribute("avgSalary", format);
        return "avgTeacherSalary";
    }

    @RequestMapping("/sumSalary")
    public String sumSalary(Model model) {
        model.addAttribute("sumSalaries", service.sumTeacherSalary());
        return "sumTeacherSalary";
    }


}
