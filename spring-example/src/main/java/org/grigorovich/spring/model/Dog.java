package org.grigorovich.spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class Dog extends Pet{
    boolean abilityToTrain;

    public Dog(int id, String type, String name, boolean abilityToTrain) {
        super(id, type, name);
        this.abilityToTrain = abilityToTrain;
    }

    public Dog(int id, String type, String name) {
        super(id, type, name);
    }


    @Override
    public void goodAnimal() {
        if (abilityToTrain==true) {
            System.out.println(this.name+" good boy");
        } else {
            System.out.println(this.name + " you should try");
        }
    }

}
