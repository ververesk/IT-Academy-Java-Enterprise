package com.grigorovich.db_it.app.controllers;

import com.grigirovich.db_it.model.Student;
import com.grigorovich.db_it.app.repositories.RepositoryFactory;
import com.grigorovich.db_it.app.repositories.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createStudent")
public class InsertStudentController extends HttpServlet {
    private final StudentRepository repository = RepositoryFactory.getStudentRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/studentInsertView.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = (String) request.getParameter("name");
            String surname = (String) request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            String username = (String) request.getParameter("username");
            Student student = new Student(name, surname, age, username);
            repository.insert(student);
            response.sendRedirect(request.getContextPath() + "/studentList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/view/studentInsertView.jsp").forward(request, response);
        }
    }
}
