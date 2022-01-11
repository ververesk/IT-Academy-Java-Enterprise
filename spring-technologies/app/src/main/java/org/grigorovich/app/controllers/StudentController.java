package org.grigorovich.app.controllers;

import org.grigorovich.app.service.EntityService;
import org.grigorovich.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private EntityService service;

    @RequestMapping("/allStudents")
    public String allStudents(Model model) { //модель нужна для того чтобы во вью можно было передать список работников
        List<Student> students=service.getAll();
        model.addAttribute("allSt", students);
        return "all-students";
    }
    @RequestMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        Student student=new Student();
        model.addAttribute("student", student);
        return "student-info";
    }
    @RequestMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) { //мы должны получить из формы работника, КОТОРГО СОЗДАЛИ
        service.saveEntity(student);
        return "redirect:/allStudents";
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("stId") int id, Model model) { //получаем из запроса значение id
        Student student= (Student) service.getEntity(id);
        model.addAttribute("student", student); //теперь вью будет отбражаться с заполненными формами
        return "student-info";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("stId") int id) { //получаем из запроса значение id
        service.deleteEntity(id);
        return "redirect:/allStudents";
    }
}
