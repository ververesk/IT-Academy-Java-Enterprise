package org.example.demo.model;

import org.example.demo.model.Account;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Teacher {

    private int id;

    @Size(min=2, message="name must be min 2 symbols")
    private String name;

    @NotBlank(message="surname is required field")
    private String surname;

    @Min(value=18, message = "must be greater than 17")
    @Max(value=99, message = "must be less than 100")
    private int age;

    private double salary;

    private Account account;

    private String group;

    public Teacher() {
       //Default Constructor
    }

    public Teacher(String name, String surname, int age, double salary, String group) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary=salary;
        this.group=group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
