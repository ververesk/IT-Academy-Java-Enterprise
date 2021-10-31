package org.example.demo.app;

import org.example.demo.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet(value = "/sum-salary")
public class SumTeachersSalary extends HttpServlet {
    private List<Teacher> teachers;

    @Override
    public void init() throws ServletException {
        super.init();
   //     teachers = initTeachers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
//        writer.write("<p><span style='color: orange;'>Средняя зарплата следующих преподавателей: "
//                + sumSalary(teachers) + "</span></p>");
        teachers.forEach(teacher -> writer.write(teacher.toString() + "</p>"));
    }

//    private List<org.example.demo.model.Teacher> initTeachers() {
//        org.example.demo.model.Teacher t1 = new org.example.demo.model.Teacher("Nikolai", 1000);
//        org.example.demo.model.Teacher t2 = new org.example.demo.model.Teacher("Olga", 1200);
//        org.example.demo.model.Teacher t3 = new org.example.demo.model.Teacher("Viktor", 1100);
//        org.example.demo.model.Teacher t4 = new org.example.demo.model.Teacher("Marina", 1050);
//        return List.of(t1, t2, t3, t4);
//    }

//    private int sumSalary(List<org.example.demo.model.Teacher> teachers) {
//        List<Integer> salaries = teachers.stream()
//                .map(org.example.demo.model.Teacher::getSalary)
//                .collect(Collectors.toList());
//        return calculator.sum(salaries);
//    }
}
