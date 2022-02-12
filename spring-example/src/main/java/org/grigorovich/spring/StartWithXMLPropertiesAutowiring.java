package org.grigorovich.spring;

import org.grigorovich.spring.model.Home;
import org.grigorovich.spring.model.Owner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXMLPropertiesAutowiring {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-with-properties-autowiring.xml");
        ctx.registerShutdownHook();


//        Home igorHome = ctx.getBean("igorHome", Home.class);
//        System.out.println(igorHome);

        Home someHome = ctx.getBean("someHome", Home.class);
        System.out.println(someHome);


    }
}
