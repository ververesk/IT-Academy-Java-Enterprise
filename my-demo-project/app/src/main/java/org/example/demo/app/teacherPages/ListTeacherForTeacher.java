package org.example.demo.app.teacherPages;

import org.example.demo.model.ModelTeacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(value = "/listForTeacher")
public class ListTeacherForTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelTeacher modelTeacher = ModelTeacher.getInstance();
        List<String> names = modelTeacher.list();
        req.setAttribute("userNames", names);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/listForTeacher.jsp");
        requestDispatcher.forward(req, resp);
    }
}
