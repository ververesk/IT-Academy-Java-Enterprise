package org.example.demo.app;

import org.example.demo.model.ModelStudent;
import org.example.demo.model.ModelTeacher;
import org.example.demo.model.Student;
import org.example.demo.model.Teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class StudentCreator {

    @RequestMapping("/HomePage") //если вводим просто слэш то возвращается это JSP
    public String showFirstView() {
        return "HomePage";
    }

    @RequestMapping("/StudentCreator")
    public String askStudentDetails(Model model) {
        model.addAttribute("student", new Student());
        return "jspStudentCreator";
    }

    @RequestMapping("/showStudentDetails")
    public String showStudentDetails(HttpServletRequest req, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult) { //bindingResult проверяем прошла ли валидация
        String stName = req.getParameter("name");
        String stSurname=req.getParameter("surname");
        int stAge=Integer.parseInt(req.getParameter("age"));
        Student st = new Student(stName, stSurname, stAge);
        ModelStudent modelStudent = ModelStudent.getInstance();
        modelStudent.add(st);
        if (bindingResult.hasErrors()) {
            return "jspStudentCreator";
        } else {
            return "jspShowStudentDetails";
        }
    }
}
