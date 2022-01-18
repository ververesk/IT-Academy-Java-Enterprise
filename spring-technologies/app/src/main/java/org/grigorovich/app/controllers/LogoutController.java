package org.grigorovich.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String saveStudent(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();
        return null;
    }

}
