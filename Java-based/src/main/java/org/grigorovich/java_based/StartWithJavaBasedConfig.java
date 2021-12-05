package org.grigorovich.java_based;

import org.grigorovich.java_based.config.JavaBasedConfig;
import org.grigorovich.java_based.model.Home;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StartWithJavaBasedConfig {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("org.grigorovich.java_based");
        ctx.registerShutdownHook();


        Home home = ctx.getBean("home", Home.class);
        System.out.println(home);


    }
}
