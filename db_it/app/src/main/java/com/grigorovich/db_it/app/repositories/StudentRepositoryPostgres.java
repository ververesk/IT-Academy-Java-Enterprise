package com.grigorovich.db_it.app.repositories;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.grigirovich.db_it.model.Course;
import com.grigirovich.db_it.model.Grade;
import com.grigirovich.db_it.model.Student;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class StudentRepositoryPostgres implements StudentRepository {
    DataSource dataSource;
    private static final String insertStudent = "insert into students (name, surname, age, username) VALUES (?, ?, ?, ?)";
    private static final String selectAllFields = "select id, name, surname, age, username from students";
    private static final String updateStudent = "update students set name=?, surname=?, age=?, username=? where id=?";
    private static final String findStudentByID = "select id, name, surname, age, username from students where id=?";
    private static final String deleteStudentByID = "delete from students where id=?";
    private static final String findMath = "select st.id st_id, c.course_id c_course_id, scg.id scg_id, name, surname, course_name, grades from students st join student_cours_grades scg on (st.id=scg.student_id) join courses c on (scg.course_id=c.course_id) where c.course_id=1";
    private static final String findNoahSmith = "select st.id st_id, c.course_id c_course_id, scg.id scg_id, name, surname, course_name, grades from students st join student_cours_grades scg on (st.id=scg.student_id) join courses c on (scg.course_id=c.course_id) where st.id=1";
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
                String username = rs.getString("username");
                Student student = new Student();
                student.withId(id);
                student.withName(name);
                student.withSurname(surname);
                student.withAge(age);
                student.withUsername(username);
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
                int stId = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String username = rs.getString("username");
                Student student = new Student(stId, name, surname, age, username);
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
            ps.setString(4, student.getUsername());
            ps.setInt(5, student.getId());
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
    public void insert(Student student) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(insertStudent)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getUsername());
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
             PreparedStatement ps = con.prepareStatement(deleteStudentByID)) {
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
    public List<Student> findMath() {
        Map<Integer, Student> studentMap = new HashMap<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findMath);
             ResultSet rs = ps.executeQuery()) {
            Map<Integer, Course> courseMap = new HashMap<>();
            Map<Integer, Grade> gradeMap = new HashMap<>();
            while (rs.next()) {
                int stId = rs.getInt("st_id");
                int cId = rs.getInt("c_course_id");
                int scgId = rs.getInt("scg_id");

                gradeMap.putIfAbsent(scgId, new Grade()
                        .withId(cId)
                        .withGrades(rs.getInt("grades")));

                courseMap.putIfAbsent(cId, new Course()
                        .withCourseId(cId)
                        .withCourseName(rs.getString("course_name")));

                studentMap.putIfAbsent(stId,
                        new Student()
                                .withId(stId)
                                .withName(rs.getString("name"))
                                .withSurname(rs.getString("surname"))
                                .addCourse(courseMap.get(cId))
                                .addGrades(gradeMap.get(scgId)));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());

        }
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public List<Student> findNoahSmith() {
        Multimap<Integer, Student> studentMap = ArrayListMultimap.create();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findNoahSmith);
             ResultSet rs = ps.executeQuery()) {
            Map<Integer, Course> courseMap = new HashMap<>();
            Map<Integer, Grade> gradeMap = new HashMap<>();
            while (rs.next()) {
                int stId = rs.getInt("st_id");
                int cId = rs.getInt("c_course_id");
                int scgId = rs.getInt("scg_id");

                gradeMap.putIfAbsent(scgId, new Grade()
                        .withId(cId)
                        .withGrades(rs.getInt("grades")));

                courseMap.putIfAbsent(cId, new Course()
                        .withCourseId(cId)
                        .withCourseName(rs.getString("course_name")));

                studentMap.put(stId,
                        new Student()
                                .withId(stId)
                                .withName(rs.getString("name"))
                                .withSurname(rs.getString("surname"))
                                .addCourse(courseMap.get(cId))
                                .addGrades(gradeMap.get(scgId)));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());

        }
        return new ArrayList<>(studentMap.values());
    }
}

