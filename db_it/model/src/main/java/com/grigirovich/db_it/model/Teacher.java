package com.grigirovich.db_it.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private Integer courseId; // потому что может быть null
    private String username;


    public Teacher withId(int id) {
        setId(id);
        return this;
    }

    public Teacher withName(String name) {
        setName(name);
        return this;
    }

    public Teacher withSurname(String surname) {
        setSurname(surname);
        return this;
    }

    public Teacher withSalary(int salary) {
        setSalary(salary);
        return this;
    }

    public Teacher withUsername(String username) {
        setUsername(username);
        return this;
    }

    public Teacher(int id, String name, String surname, int salary, Integer courseId, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.courseId = courseId;
        this.username = username;
    }

    public Teacher(String name, String surname, int salary, Integer courseId, String username) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.courseId = courseId;
        this.username = username;
    }
}
