package com.grigorovich.db_it.app.repositories;

import com.grigirovich.db_it.model.Course;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class CourseRepositoryPostgres implements CourseRepository{
    DataSource dataSource;
    private static final String insertCourse = "insert into courses (course_name) VALUES (?)";
    private static final String selectAllFields = "select course_id, course_name from courses";
    private static final String findCourseByID = "select course_id, course_name from courses where course_id=?";
    private static final String deleteCourseByID = "delete from courses where course_id=?";

    private static volatile CourseRepositoryPostgres instance;

    private CourseRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static CourseRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (CourseRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new CourseRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(selectAllFields);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String courseName = rs.getString("course_name");
                Course course = new Course();
                course.withCourseId(courseId);
                course.withCourseName(courseName);
                courseList.add(course);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return courseList;
    }

    @Override
    public Course find(int courseId) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findCourseByID)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idC = rs.getInt("course_id");
                String name = rs.getString("course_name");
                Course course = new Course(idC, name);
                return course;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Course entity) {

    }

    @Override
    public void insert(Course course) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(insertCourse)) {
            ps.setString(1, course.getCourseName());
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
    public void remove(int course_id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteCourseByID)) {
            ps.setInt(1, course_id);
            int affectedRows = ps.executeUpdate();
            System.out.println("!!!!!!!!!!!!!!!!!!!!"+affectedRows);
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            con.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
