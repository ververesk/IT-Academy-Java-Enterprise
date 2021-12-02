package org.grigorovich.spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class Cat extends Pet{
    boolean abilityToCatchMice;

    public Cat(int id, String type, String name, boolean abilityToCatchMice) {
        super(id, type, name);
        this.abilityToCatchMice = abilityToCatchMice;
    }


    @Override
    public void goodAnimal() {
        if (abilityToCatchMice==true) {
            System.out.println(this.name+" good boy");
        } else {
            System.out.println(this.name + " you should try");
        }
    }
}
