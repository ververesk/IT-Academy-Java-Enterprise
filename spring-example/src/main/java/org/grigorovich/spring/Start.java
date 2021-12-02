package org.grigorovich.spring;

import org.grigorovich.spring.model.Dog;
import org.grigorovich.spring.model.Home;
import org.grigorovich.spring.model.Owner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.registerShutdownHook();

        Home veronikaHome = ctx.getBean("veronikaHome",Home.class);
        System.out.println(veronikaHome);
        Home dimaHome = ctx.getBean("dimaHome",Home.class);
        System.out.println(dimaHome);

//        Dog dog = new Dog(1,"dog","gav",false);
//        System.out.println(dog);
//        Owner owner=new Owner(1, "Bob", List.of(dog));
//        System.out.println(owner);
//        Home bobHome=new Home(1,50,owner);
//        System.out.println(bobHome);
//        dog.goodAnimal();

    }
}
