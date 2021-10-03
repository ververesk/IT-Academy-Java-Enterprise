import calc.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/average-marks")
public class AverageMarksOfStudents extends HttpServlet {
        private Calculator calculator;
        private List<Student> students;
        private List<Double> marks;


        @Override
        public void init() throws ServletException {
                super.init();
                students = initStudents();
                calculator = Calculator.getInstance();
                marks= addToList(students);
        }

        @Override
        public String toString() {
                return "AverageMarksOfStudents{" +
                        "marks=" + marks +
                        '}';
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter writer = resp.getWriter();
                writer.write("<p><span " + addToList(students).toString() + "</span></p>");

        }

        private List<Student> initStudents() {
                Student st1 = new Student("Nikolaj", 7, 8, 9, 6);
                Student st2 = new Student("Maria", 9, 8, 9, 9);
                Student st3 = new Student("Petr", 7, 8, 10, 5);
                Student st4 = new Student("Olga", 5, 8, 6, 6);
                return List.of(st1, st2, st3, st4);
        }

        private List<Double> addToList(List<Student> students) {
                List<Double> marks=new ArrayList<>();
                Map<String, List<Integer>> studentsMap = new HashMap();
                studentsMap.put(students.get(0).getName(), List.of(students.get(0).getMathGrade(), students.get(0).getEconomicGrade(), students.get(0).getEnglishGrade(), students.get(0).getComputerScienceGrade()));
                studentsMap.put(students.get(1).getName(), List.of(students.get(1).getMathGrade(), students.get(1).getEconomicGrade(), students.get(1).getEnglishGrade(), students.get(1).getComputerScienceGrade()));
                studentsMap.put(students.get(2).getName(), List.of(students.get(2).getMathGrade(), students.get(2).getEconomicGrade(), students.get(2).getEnglishGrade(), students.get(2).getComputerScienceGrade()));
                studentsMap.put(students.get(3).getName(), List.of(students.get(3).getMathGrade(), students.get(3).getEconomicGrade(), students.get(3).getEnglishGrade(), students.get(3).getComputerScienceGrade()));
                for (String key : studentsMap.keySet()) {
                        double average = calculator.average(studentsMap.get(key));
                        marks.add(average);
                }
                return marks;
        }
}
