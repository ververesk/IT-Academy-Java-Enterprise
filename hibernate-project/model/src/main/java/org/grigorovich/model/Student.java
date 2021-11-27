package org.grigorovich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

@EqualsAndHashCode(exclude = "courseList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "username")
    private String username;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "student_cours_grades", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courseList;


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

    public void addCourseToStudent(Course course) {
        if (courseList == null) {
            courseList=new ArrayList<>();
        }
        courseList.add(course);
    }
}