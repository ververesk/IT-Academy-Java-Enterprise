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

    private String [] groups;

    private Map<String , String> groupsList;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student() {
        groupsList=new HashMap<>();
        groupsList.put("English", "EN");
        groupsList.put("Math", "MATH");
        groupsList.put("Computer Science", "CS");
        groupsList.put("JavaEE", "JEE");
        groupsList.put("Spring", "SPRING");
        groupsList.put("Data Base", "DB");
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

    public String[] getGroups() {
        return groups;
    }

    public void setGroups(String[] groups) {
        this.groups = groups;
    }

    public Map<String, String> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(Map<String, String> groupsList) {
        this.groupsList = groupsList;
    }
}
