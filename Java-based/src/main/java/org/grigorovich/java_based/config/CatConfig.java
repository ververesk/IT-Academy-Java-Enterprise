package org.grigorovich.java_based.config;

import org.grigorovich.java_based.model.Cat;
import org.grigorovich.java_based.model.Dog;
import org.grigorovich.java_based.model.Home;
import org.grigorovich.java_based.model.Owner;
import org.grigorovich.java_based.qualifiers.IgorQualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource({"classpath:cat.properties"})
public class CatConfig {

    @Bean
    public Cat murka(@Value("${murka.id}") int id, @Value("${murka.type}") String type,
                     @Value("${murka.name}") String name, @Value("${murka.abilityToCatchMice}") boolean abilityToCatchMice) {
        Cat murka = new Cat(id, type, name, abilityToCatchMice);
        return murka;
    }

    @Bean
    public Cat barsik() {
        Cat barsik = new Cat(2, "cat", "barsik", false);
        return barsik;
    }

}
