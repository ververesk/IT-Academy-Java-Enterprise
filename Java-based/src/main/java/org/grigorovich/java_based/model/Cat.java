package org.grigorovich.java_based.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@Component
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

    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": init method");
        goodAnimal();
    }


    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + ": destroy method");
    }
}
