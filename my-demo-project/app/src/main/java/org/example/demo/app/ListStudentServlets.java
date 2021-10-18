package org.example.demo.app;

import org.example.demo.model.ModelStudent;
import org.example.demo.model.ModelTeacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
@WebServlet(value = "/listStudent")
public class ListStudentServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelStudent modelStudent = ModelStudent.getInstance();
        List<String> surnames = modelStudent.listStudent();
        req.setAttribute("userSurnames", surnames);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/listStudent.jsp");
        requestDispatcher.forward(req, resp);
    }
}
