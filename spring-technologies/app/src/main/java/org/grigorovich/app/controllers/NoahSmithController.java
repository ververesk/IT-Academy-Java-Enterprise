package org.grigorovich.app.controllers;

import org.grigorovich.app.service.EntityService;
import org.grigorovich.model.Course;
import org.grigorovich.model.NoahSmith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoahSmithController {

    @Autowired
    @Qualifier("noahSmithServiceImp")
    private EntityService service;

    @RequestMapping("/noahSmith")
    public String noahSmith(Model model) {
        List<NoahSmith> noahSmith = service.getAll();
        model.addAttribute("noahSmith", noahSmith);
        return "all-noahSmith";
    }
}
