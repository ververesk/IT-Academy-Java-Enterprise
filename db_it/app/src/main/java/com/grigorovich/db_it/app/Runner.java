package com.grigorovich.db_it.app;

import com.grigirovich.db_it.model.Teacher;
import com.grigorovich.db_it.app.repositories.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//public class Runner {
//    private static final TeacherRepository repository = RepositoryFactory.getTeacherRepository();
//    public static void main(String[] args) {
//        int sum = repository.sumTeacherSalary();
//        System.out.println(sum);
//
//    }
//}
