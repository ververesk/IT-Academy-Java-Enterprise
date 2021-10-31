package org.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
сделала синглетоном в условиях многопоточности, вдруг когда-нибудь будет два администратора
 */
public class ModelTeacher {
    private static ModelTeacher instance = new ModelTeacher();

    private List<Teacher> modelTeacher;

    public static ModelTeacher getInstance() {
        return instance;
    }

    private ModelTeacher() {
        modelTeacher = new ArrayList<>();
    }

    public void add(Teacher teacher) {
        modelTeacher.add(teacher);
    }

    public List<Double> salaryList() {
        return modelTeacher.stream()
                .map(Teacher::getSalary)
                .collect(Collectors.toList());
    }

    public List<String> list() {
        return modelTeacher.stream()
                .map(Teacher::getName)
                .collect(Collectors.toList());
    }
}

