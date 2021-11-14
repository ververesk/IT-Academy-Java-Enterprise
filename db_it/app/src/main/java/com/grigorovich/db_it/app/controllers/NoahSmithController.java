package com.grigorovich.db_it.app.controllers;

import com.grigorovich.db_it.app.repositories.RepositoryFactory;
import com.grigorovich.db_it.app.repositories.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NoahSmith")
public class NoahSmithController extends HttpServlet {
    private final StudentRepository repository = RepositoryFactory.getStudentRepository();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("noahSmith", repository.findNoahSmith());
        req.getRequestDispatcher("/WEB-INF/view/studentNoahSmith.jsp").forward(req, resp);
    }
}

