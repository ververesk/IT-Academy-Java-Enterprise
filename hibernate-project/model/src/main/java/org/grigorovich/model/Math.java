package org.grigorovich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "math")
public class Math {
    @Id
    @Column(name = "id", insertable = false)
    private int id;

    @Column(name = "grades")
    private int grades;

    @Column(name = "student_name", insertable = false)
    private String studentName;
}
