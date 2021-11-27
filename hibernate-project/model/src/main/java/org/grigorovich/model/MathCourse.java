package org.grigorovich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "math")
public class MathCourse {
    @Id
    @Column(name = "id", updatable = false)
    private int id;
    @Min(value=1, message = "must be greater than 0")
    @Max(value=11, message = "must be less than 11")
    @Column(name = "grades")
    private int grades;

    @Column(name = "student_name", updatable = false)
    private String studentName;

}
