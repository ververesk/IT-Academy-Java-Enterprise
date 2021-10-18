package org.example.demo.app;

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
public class TeacherCreator {

    @RequestMapping("/TeacherCreator")
    public String askTeacherDetails(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "jspTeacherCreator";
    }

    @RequestMapping("/showTeacherDetails")
    public String showTeacherDetails(HttpServletRequest req, @Valid @ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult) { //bindingResult проверяем прошла ли валидация
        String teachName = req.getParameter("name");
        String teachSurname=req.getParameter("surname");
        int teachAge=Integer.parseInt(req.getParameter("age"));
        double teachSalary=Double.parseDouble(req.getParameter("salary"));
        String teachGroup=req.getParameter("group");
        Teacher teach = new Teacher(teachName, teachSurname, teachAge, teachSalary, teachGroup);
        ModelTeacher modelTeacher = ModelTeacher.getInstance();
        modelTeacher.add(teach);
        if (bindingResult.hasErrors()) {
            return "jspTeacherCreator";
        } else {
            return "jspShowTeacherDetails";
        }
    }
}
