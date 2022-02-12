package org.grigorovich.controllers;

import org.grigorovich.model.MathCourse;
import org.grigorovich.service.MathCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MathCourseController {
    @Autowired
    private MathCourseService service;

    @RequestMapping("/allStudentsOfMath")
    public String allStudentOfMath(Model model) {
        List<MathCourse> mathCourseList = service.showAllStudents();
        model.addAttribute("mathCourseList", mathCourseList);
        return "all-studentsOfMath";
    }

    @RequestMapping("/saveMathCourse")
    public String saveMathCourse(@Valid @ModelAttribute("mathCourse") MathCourse mathCourse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "mathCourse-info";
        } else {
            service.saveMathCourse(mathCourse);
            return "redirect:/allStudentsOfMath";
        }
    }

    @RequestMapping("/updateMathCourse")
    public String updateMathCourse(@RequestParam("id") int id, Model model) {
        MathCourse mathCourse = (MathCourse) service.getMathCourse(id);
        model.addAttribute("mathCourse", mathCourse);
        return "mathCourse-info";
    }
}

