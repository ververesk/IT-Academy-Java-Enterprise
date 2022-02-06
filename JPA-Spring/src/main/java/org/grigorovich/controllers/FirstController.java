package org.grigorovich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class FirstController {
    @RequestMapping("/")
    public ModelAndView showFirstView(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("principal", principal);
        modelAndView.setViewName("first-view");
        return modelAndView;
    }
}
