package org.grigorovich.controllers;

import org.grigorovich.model.NoahSmith;
import org.grigorovich.service.NoahSmithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoahSmithController {

    @Autowired
    private NoahSmithService service;

    @RequestMapping("/noahSmith")
    public String noahSmith(Model model) {
        List<NoahSmith> noahSmith = service.getAllInfo();
        model.addAttribute("noahSmith", noahSmith);
        return "all-noahSmith";
    }
}
