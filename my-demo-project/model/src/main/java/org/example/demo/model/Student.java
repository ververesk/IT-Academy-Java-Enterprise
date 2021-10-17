package org.example.demo.model;

import org.example.demo.model.Account;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

public class Student {

    private int id;
    @Size(min=2, message="name must be min 2 symbols")
    private String name;

    @NotBlank(message="surname is required field")
    private String surname;

    @Min(value=18, message = "must be greater than 17")
    @Max(value=99, message = "must be less than 100")
    private int age;

    private Account account;

    private List<Integer> marks=new ArrayList<>();

    private Map<String,String> groupList;


    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student() {
        groupList=new HashMap<>();
        groupList.put("English", "EN");
        groupList.put("Math", "MATH");
        groupList.put("Computer Science", "CS");
        groupList.put("JavaEE", "JEE");
        groupList.put("Spring", "SPRING");
        groupList.put("DATA BASE", "DB");
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

    public Map<String, String> getGroupList() {
        return groupList;
    }

    public void setGroupList(Map<String, String> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "org.example.demo.model.Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
