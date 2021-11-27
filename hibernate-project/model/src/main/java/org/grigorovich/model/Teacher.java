package org.grigorovich.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(exclude = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private int salary;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "username")
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
}