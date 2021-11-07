package com.grigorovich.db_it.app.repositories;

import com.grigirovich.db_it.model.Student;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class StudentRepositoryPostgres implements StudentRepository {
    DataSource dataSource;
    private static final String INSERT_Student_SQL = "INSERT INTO students (name, surname, age) VALUES (?, ?, ?)";
    private static final String selectAllFields = "select id, name, surname, age from students";
    private static final String updateStudent = "Update students set name=?, surname=?, age=? where id=?";
    private static final String findStudentByID = "select id, name, surname, age from students where id=?";

    private static volatile StudentRepositoryPostgres instance;

    private StudentRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static StudentRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (StudentRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new StudentRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(selectAllFields);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                Student student = new Student();
                student.withId(id);
                student.withName(name);
                student.withSurname(surname);
                student.withAge(age);
                studentList.add(student);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return studentList;
    }

    @Override
    public Student find(int id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findStudentByID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                Student student = new Student(id, name, surname, age);
                return student;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }


    @Override
    public void update(Student student) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(updateStudent)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setInt(3, student.getAge());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

//    @Override
//    public Optional<Student> find(int id) {
//        return Optional.empty();
//    }

    //   @Override
    //   public Student update(Student entity) {


//        PreparedStatement pstm = conn.prepareStatement(sql);
//
//        pstm.setString(1, product.getName());
//        pstm.setFloat(2, product.getPrice());
//        pstm.setString(3, product.getCode());
//        pstm.executeUpdate();
//        return null;
//    }
//
//    @Override
//    public Student insert(Student entity) {
//        PreparedStatement pstm = conn.prepareStatement(sql);
//
//        pstm.setString(1, product.getName());
//        pstm.setFloat(2, product.getPrice());
//        pstm.setString(3, product.getCode());
//        pstm.executeUpdate();
//        return null;
    //}

}
