package org.grigorovich.spring.model;

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

    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": init method");
    }


    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + ": destroy method");
    }
}
