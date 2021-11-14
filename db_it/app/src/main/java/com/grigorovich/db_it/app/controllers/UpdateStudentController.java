package com.grigorovich.db_it.app.controllers;

import com.grigirovich.db_it.model.Student;
import com.grigorovich.db_it.app.repositories.RepositoryFactory;
import com.grigorovich.db_it.app.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebServlet(urlPatterns = {"/updateStudent"})
public class UpdateStudentController extends HttpServlet {
    private final StudentRepository repository = RepositoryFactory.getStudentRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = repository.find(id);
        if (student !=null) {
            request.setAttribute("student", student);
            getServletContext().getRequestDispatcher("/WEB-INF/view/studentUpdateView.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = (String) request.getParameter("name");
        String surname = (String) request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        String username = (String) request.getParameter("username");
        Student student = new Student(id, name, surname, age, username);
        repository.update(student);
        response.sendRedirect(request.getContextPath() + "/studentList");
    }
}
