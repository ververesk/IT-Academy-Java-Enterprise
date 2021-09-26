package java.students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades=new ArrayList<>();

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
