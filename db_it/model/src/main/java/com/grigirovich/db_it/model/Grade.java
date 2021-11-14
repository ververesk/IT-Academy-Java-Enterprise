package com.grigirovich.db_it.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade implements Serializable {
    private int id;
    private int grades;

    public Grade withId(int id) {
        setId(id);
        return this;
    }

    public Grade withGrades(int grades) {
        setGrades(grades);
        return this;
    }
}
