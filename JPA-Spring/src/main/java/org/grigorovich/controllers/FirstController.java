package org.grigorovich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class FirstController {
    @RequestMapping("/")
    public String showFirstView(Principal principal, Model model) {
        model.addAttribute("principal", principal);
        return "first-view";
    }
}
