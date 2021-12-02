package org.grigorovich.spring;

import org.grigorovich.spring.model.Dog;
import org.grigorovich.spring.model.Home;
import org.grigorovich.spring.model.Owner;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        Dog dog = new Dog(1,"dog","gav",false);
        System.out.println(dog);
        Owner owner=new Owner(1, "Bob", List.of(dog));
        System.out.println(owner);
        Home bobHome=new Home(1,50,owner);
        System.out.println(bobHome);
        dog.goodAnimal();

    }
}
