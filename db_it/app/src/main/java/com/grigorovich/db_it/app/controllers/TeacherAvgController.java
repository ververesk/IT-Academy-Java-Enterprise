package com.grigorovich.db_it.app.controllers;

import com.grigorovich.db_it.app.repositories.RepositoryFactory;
import com.grigorovich.db_it.app.repositories.TeacherRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/avgSalary"})
public class TeacherAvgController extends HttpServlet {

    private final TeacherRepository repository = RepositoryFactory.getTeacherRepository();

    //знаю что криво но по-другому не получается не могу соединить с вьюхой
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: orange;'>Средняя зарплата преподавателей: "
                + repository.avgTeacherSalary() + "</span></p>");
    }
}

