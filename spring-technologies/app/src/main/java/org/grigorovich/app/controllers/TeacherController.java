package org.grigorovich.app.controllers;

import org.grigorovich.app.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {
    @Autowired
    @Qualifier("teacherServiceImpl")
    private EntityService service;
}
