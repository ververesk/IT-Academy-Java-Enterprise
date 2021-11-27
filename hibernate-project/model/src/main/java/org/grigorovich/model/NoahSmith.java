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
@Table(name = "NoahSmith")
public class NoahSmith {
    @Id
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "grades", updatable = false)
    private int grades;

    @Column(name = "course_name", updatable = false)
    private String courseName;
}

