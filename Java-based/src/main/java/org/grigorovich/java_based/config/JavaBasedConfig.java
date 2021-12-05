package org.grigorovich.java_based.config;

import org.grigorovich.java_based.model.*;
import org.grigorovich.java_based.qualifiers.IgorQualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


import java.util.List;
import java.util.Map;

@Import({CatConfig.class, DogConfig.class, OwnerConfig.class})
@Configuration
public class JavaBasedConfig {

//    @Bean
//    public Home home(@IgorQualifier Owner owner) {
//        Home home = new Home(1, 150, null);
//        home.setOwner(owner);
//        return home;
//    }
}
