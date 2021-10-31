package org.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
сделала синглетоном в условиях многопоточности, вдруг когда-нибудь будет два администратора
 */
public class ModelStudent {
    private static ModelStudent instance = new ModelStudent();

    private List<Student> modelStudent;

    public static ModelStudent getInstance() {
        return instance;
    }

    private ModelStudent() {
        modelStudent = new ArrayList<>();
    }

    public void add(Student student) {
        modelStudent.add(student);
    }

    public List<String> listStudent() {
        return modelStudent.stream()
                .map(Student::getSurname)
                .collect(Collectors.toList());
    }
}
