package com.grigorovich.db_it.app.repositories;

import com.grigirovich.db_it.model.Teacher;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TeacherRepositoryPostgres implements TeacherRepository {
    DataSource dataSource;
    private static final String insertTeacher = "insert into teachers (name, surname, salary, course_id, username) VALUES (?, ?, ?, ?, ?)";
    private static final String selectAllFields = "select id, name, surname, salary, course_id, username from teachers";
    private static final String updateTeacher = "update teachers set name=?, surname=?, salary=?, course_id=?, username=? where id=?";
    private static final String findTeacherByID = "select id, name, surname, salary, course_id, username from teachers where id=?";
    private static final String deleteTeacherByID = "delete from teachers where id=?";
    private static final String sumSalaryTeachers = "select sum(salary) as \"sum\" from teachers";
    private static final String avgTeacherSalary = "select avg(salary) average_salary from teachers";


    private static volatile TeacherRepositoryPostgres instance;

    private TeacherRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static TeacherRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (TeacherRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new TeacherRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teacherList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(selectAllFields);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int salary = rs.getInt("salary");
                Integer courseId = rs.getInt("course_id");
                String username = rs.getString("username");
                Teacher teacher = new Teacher();
                teacher.withId(id);
                teacher.withName(name);
                teacher.withSurname(surname);
                teacher.withSalary(salary);
                teacher.setCourseId(courseId);
                teacher.withUsername(username);
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return teacherList;
    }

    @Override
    public Teacher find(int id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findTeacherByID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int teachId = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int salary = rs.getInt("salary");
                Integer courseId = rs.getInt("course_id");
                String username = rs.getString("username");
                Teacher teacher = new Teacher(teachId, name, surname, salary, courseId, username);
                return teacher;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Teacher teacher) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(updateTeacher)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setInt(3, teacher.getSalary());
            ps.setInt(4, teacher.getCourseId());
            ps.setString(5, teacher.getUsername());
            ps.setInt(6, teacher.getId());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            con.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void insert(Teacher teacher) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(insertTeacher)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setInt(3, teacher.getSalary());
            ps.setInt(4, teacher.getCourseId());
            ps.setString(5, teacher.getUsername());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            con.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void remove(int id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteTeacherByID)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            con.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public int sumTeacherSalary() {
        int sum = 0;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sumSalaryTeachers);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                sum = rs.getInt("sum");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return sum;
    }

    @Override
    public double avgTeacherSalary() {
        double avg = 0;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(avgTeacherSalary);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                avg = rs.getDouble("average_salary");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return avg;
    }
}

