package org.grigorovich.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(exclude = "studentList")
@Entity
@Table(name = "courses")
@SelectBeforeUpdate
@DynamicUpdate
@DynamicInsert
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    @NotBlank(message = "this is required field")
    private String courseName;


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

    @Override
    public String toString() {
        return this.courseName;
    }
}
