package org.grigorovich.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "studentList")
@Entity
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "student_cours_grades", joinColumns = @JoinColumn(name="course_id"), inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> studentList;

    public void addStudentToCourse(Student student) {
        if (studentList==null) {
            studentList=new ArrayList<>();
        }
        studentList.add(student);
    }

    public Course withCourseId(int courseId) {
        setCourseId(courseId);
        return this;
    }

    public Course withCourseName(String courseName) {
        setCourseName(courseName);
        return this;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }
}
