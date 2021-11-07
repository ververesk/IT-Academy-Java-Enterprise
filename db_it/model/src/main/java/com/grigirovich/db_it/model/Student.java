package com.grigirovich.db_it.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String username;
    private Set<Course> courseSet=new HashSet<>();
    private Grade grade;

    public Student(String name, String surname, int age, String username) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.username = username;
    }

    public Student(int id, String name, String surname, int age, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.username = username;
    }

    public Student withId(int id) {
        setId(id);
        return this;
    }

    public Student withName(String name) {
        setName(name);
        return this;
    }

    public Student withSurname(String surname) {
        setSurname(surname);
        return this;
    }

    public Student withAge(int age) {
        setAge(age);
        return this;
    }

    public Student withUsername(String username) {
        setUsername(username);
        return this;
    }

    public Student addCourse(Course course) {
        if (courseSet != null) {
            courseSet.add(course);
        }
        return this;
    }

    public Student withGrade(Grade grade) {
        setGrade(grade);
        return this;
    }
}
