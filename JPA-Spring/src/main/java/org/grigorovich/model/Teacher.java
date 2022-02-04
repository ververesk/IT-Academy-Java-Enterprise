package org.grigorovich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode(exclude = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
@SelectBeforeUpdate
@DynamicUpdate
@DynamicInsert
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message="this is required field")
    private String name;

    @Column(name = "surname")
    @NotBlank(message="this is required field")
    private String surname;

    @Column(name = "salary")
    private int salary;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "username")
    private String username;

    public Teacher(String name, String surname, int salary, String username) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.username = username;
    }

    public Teacher(int id, String name, String surname, int salary, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.username = username;
    }


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

    public Teacher withCourse(Course course) {
        setCourse(course);
        return this;
    }
}
