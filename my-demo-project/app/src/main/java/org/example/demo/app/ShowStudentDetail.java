package org.example.demo.app;

import org.example.demo.model.Student;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

@RequestMapping("/showStudentDetail")
public class ShowStudentDetail extends HttpServlet{

        public String showStudentDetails(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) { //bindingResult проверяем прошла ли валидация
            if (bindingResult.hasErrors()) {
                return "jspStudentCreator";
            } else {
                return "jspShowStudentDetails";
            }
        }
}
