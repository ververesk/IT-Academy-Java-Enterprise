package java;

import java.teachers.Teacher;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Integer> listGrades=new ArrayList<>();
        Teacher t1=new Teacher("Nikolai",1000);
        Teacher t2=new Teacher("Olga",1200);
        Teacher t3=new Teacher("Viktor",1100);
        Teacher t4=new Teacher("Marina",1050);
        listGrades.add(t1.getSalary());
        listGrades.add(t2.getSalary());
        listGrades.add(t3.getSalary());
        listGrades.add(t4.getSalary());
        System.out.println();
    }
}
