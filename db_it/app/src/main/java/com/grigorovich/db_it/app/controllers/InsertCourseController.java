package com.grigorovich.db_it.app.controllers;
import com.grigirovich.db_it.model.Course;
import com.grigorovich.db_it.app.repositories.CourseRepository;
import com.grigorovich.db_it.app.repositories.RepositoryFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createCourse")
public class InsertCourseController extends HttpServlet {
    private final CourseRepository repository = RepositoryFactory.getCourseRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/courseInsertView.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = (String) request.getParameter("courseName");
            Course course = new Course(name);
            repository.insert(course);
            response.sendRedirect(request.getContextPath() + "/courseList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/view/courseInsertView.jsp").forward(request, response);
        }
    }
}

