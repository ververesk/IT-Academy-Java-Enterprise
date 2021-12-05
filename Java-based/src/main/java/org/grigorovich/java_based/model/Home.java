package org.grigorovich.java_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {
    private int id;
    private int square;
    private Owner owner;

    public Home(int id, int square) {
        this.id = id;
        this.square = square;
    }


}
