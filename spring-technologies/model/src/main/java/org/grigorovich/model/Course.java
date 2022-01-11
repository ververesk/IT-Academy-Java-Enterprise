package org.grigorovich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    @NotBlank(message="this is required field")
    private String courseName;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courseList")
    @JoinTable(name = "student_cours_grades", joinColumns = @JoinColumn(name="course_id"), inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> studentList = new ArrayList<>();

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
