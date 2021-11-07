package com.grigorovich.db_it.app;

import com.grigirovich.db_it.model.Student;
import com.grigirovich.db_it.model.Teacher;
import com.grigorovich.db_it.app.repositories.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final StudentRepository repository = RepositoryFactory.getStudentRepository();
    public static void main(String[] args) {
        List<Student> students = repository.findMath();
        System.out.println(students);

    }
}
