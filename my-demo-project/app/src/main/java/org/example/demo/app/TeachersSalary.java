package org.example.demo.app;

import org.example.demo.calc.Calculator;
import org.example.demo.model.ModelTeacher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(value = "/avgTeachersSalary")
public class TeachersSalary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        ModelTeacher modelTeacher = ModelTeacher.getInstance();
        List<Double> salaryList = modelTeacher.salaryList();
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: orange;'>Средняя зарплата преподавателей: "
                + Calculator.averageSalaryOfTeachers(salaryList) + "</span></p>");
    }
}


