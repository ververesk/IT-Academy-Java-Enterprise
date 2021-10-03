import calc.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet(value = "/sum-salary")
public class SumTeachersSalary extends HttpServlet {
    private Calculator calculator;
    private List<Teacher> teachers;

    @Override
    public void init() throws ServletException {
        super.init();
        teachers = initTeachers();
        calculator = new Calculator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: orange;'>Средняя зарплата следующих преподавателей: "
                + averageSalary(teachers) + "</span></p>");
        teachers.forEach(teacher -> writer.write(teacher.toString() + "</p>"));
    }

    private static List<Teacher> initTeachers() {
        List<Integer> listGrades = new ArrayList();
        Teacher t1 = new Teacher("Nikolai", 1000);
        Teacher t2 = new Teacher("Olga", 1200);
        Teacher t3 = new Teacher("Viktor", 1100);
        Teacher t4 = new Teacher("Marina", 1050);
        return List.of(t1, t2, t3, t4);
    }

    private int averageSalary(List<Teacher> teachers) {
        List<Integer> salaries = teachers.stream()
                .map(Teacher::getSalary)
                .collect(Collectors.toList());
        return calculator.sum(salaries);
    }
}
