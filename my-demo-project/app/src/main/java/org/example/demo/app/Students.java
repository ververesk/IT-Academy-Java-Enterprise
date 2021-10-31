package org.example.demo.app;

import org.example.demo.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(value = "/students")
public class Students extends HttpServlet {
        private List<Student> students;

        @Override
        public void init() throws ServletException {
                super.init();
   //             students = initStudents();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter writer = resp.getWriter();
                students.forEach(student -> writer.write(student.toString() + "</p>"));

        }

//        private List<org.example.demo.model.Student> initStudents() {
//                org.example.demo.model.Student st1 = new org.example.demo.model.Student("Nikolaj", 7, 8, 9, 6);
//                org.example.demo.model.Student st2 = new org.example.demo.model.Student("Maria", 9, 8, 9, 9);
//                org.example.demo.model.Student st3 = new org.example.demo.model.Student("Petr", 7, 8, 10, 5);
//                org.example.demo.model.Student st4 = new org.example.demo.model.Student("Olga", 5, 8, 6, 6);
//                return List.of(st1, st2, st3, st4);
//        }
}
