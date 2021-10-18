package org.example.demo.app;
import org.example.demo.model.ModelTeacher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/avgTeachersSalary")
public class TeachersSalary extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelTeacher modelTeacher = ModelTeacher.getInstance();
        List<Double> salaryList = modelTeacher.salaryList();
        req.setAttribute("teacherSalary",salaryList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/avgTeachersSalary.jsp");
        requestDispatcher.forward(req, resp);
    }
}


