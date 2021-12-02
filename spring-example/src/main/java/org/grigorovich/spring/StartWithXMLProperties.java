package org.grigorovich.spring;

import org.grigorovich.spring.model.Home;
import org.grigorovich.spring.model.Owner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXMLProperties {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-with-properties.xml");
        ctx.registerShutdownHook();

        Owner veronika = ctx.getBean("veronika", Owner.class);
        System.out.println(veronika);


    }
}
