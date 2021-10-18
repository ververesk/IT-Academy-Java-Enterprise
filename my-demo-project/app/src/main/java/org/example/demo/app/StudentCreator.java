package org.example.demo.app;

import org.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


@Controller
public class StudentCreator {

    @RequestMapping("/") //если вводим просто слэш то возвращается это JSP
    public String showFirstView() {
        return "hello";
    }

    @RequestMapping("/StudentCreator")
    public String askStudentDetails(Model model) {
        model.addAttribute("student", new Student());
        return "jspStudentCreator";
    }

    @RequestMapping("/showStudentDetails")
    public String showStudentDetails(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) { //bindingResult проверяем прошла ли валидация
        if (bindingResult.hasErrors()) {
            return "jspStudentCreator";
        } else {
            return "jspShowStudentDetails";
        }
    }
}
