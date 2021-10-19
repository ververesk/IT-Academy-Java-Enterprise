package org.example.demo.app.userPages;

import org.example.demo.model.ModelStudent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(value = "/listStudentForUser")
public class ListStudentServletsForUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelStudent modelStudent = ModelStudent.getInstance();
        List<String> surnames = modelStudent.listStudent();
        req.setAttribute("userSurnames", surnames);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/listStudentForUser.jsp");
        requestDispatcher.forward(req, resp);
    }
}

