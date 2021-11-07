package com.grigorovich.db_it.app.controllers;

import com.grigirovich.db_it.model.Student;
import com.grigirovich.db_it.model.Teacher;
import com.grigorovich.db_it.app.repositories.RepositoryFactory;
import com.grigorovich.db_it.app.repositories.StudentRepository;
import com.grigorovich.db_it.app.repositories.TeacherRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/teacherList"})
public class TeacherListController extends HttpServlet {
    private final TeacherRepository repository = RepositoryFactory.geTeacherRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teacher> teacherList = repository.findAll();
        request.setAttribute("teachers", teacherList);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/teachersListView.jsp");
        dispatcher.forward(request, response);
    }
}


