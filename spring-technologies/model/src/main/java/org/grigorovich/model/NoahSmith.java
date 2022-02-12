package org.grigorovich.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NoahSmith")
@DynamicUpdate
public class NoahSmith implements Serializable {
    @Id
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "grades", updatable = false)
    private Integer grades;

    @Column(name = "course_name", updatable = false)
    private String courseName;
}

