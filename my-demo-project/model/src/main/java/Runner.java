import calc.Calculator;
import students.Student;
import teachers.Teacher;

import java.util.*;

public class Runner {

    private Runner() {
    }

    public static void main(String[] args) {
        workWithStudents();
        workWithTeachers();
    }

    private static void workWithStudents() {
        List<Integer> listGrades = new ArrayList();
        Teacher t1 = new Teacher("Nikolai", 1000);
        Teacher t2 = new Teacher("Olga", 1200);
        Teacher t3 = new Teacher("Viktor", 1100);
        Teacher t4 = new Teacher("Marina", 1050);
        listGrades.add(t1.getSalary());
        listGrades.add(t2.getSalary());
        listGrades.add(t3.getSalary());
        listGrades.add(t4.getSalary());
        System.out.println("Сумма зарплат учителей: " + Calculator.sum(listGrades));
    }

    private static void workWithTeachers() {
        Student st1 = new Student("Nikolaj", 7, 8, 9, 6);
        Student st2 = new Student("Maria", 9, 8, 9, 9);
        Student st3 = new Student("Petr", 7, 8, 10, 5);
        Student st4 = new Student("Olga", 5, 8, 6, 6);
        Map<String, List<Integer>> studentsMap = new HashMap();
        studentsMap.put(st1.getName(), List.of(st1.getMathGrade(), st1.getEconomicGrade(), st1.getEnglishGrade(), st1.getComputerScienceGrade()));
        studentsMap.put(st2.getName(), List.of(st2.getMathGrade(), st2.getEconomicGrade(), st2.getEnglishGrade(), st2.getComputerScienceGrade()));
        studentsMap.put(st3.getName(), List.of(st3.getMathGrade(), st3.getEconomicGrade(), st3.getEnglishGrade(), st3.getComputerScienceGrade()));
        studentsMap.put(st4.getName(), List.of(st4.getMathGrade(), st4.getEconomicGrade(), st4.getEnglishGrade(), st4.getComputerScienceGrade()));
        for (String key : studentsMap.keySet()) {
            double average = Calculator.average(studentsMap.get(key));
            System.out.println("Средняя оценка ученика " + key + "= " + average);
        }

    }
}
