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
@PropertySource({"classpath:dog.properties"})
public class DogConfig {

    @Bean
    public Dog mishelle(@Value("${mishelle.id}") int id, @Value("${mishelle.type}") String type,
                        @Value("${mishelle.name}") String name, @Value("${mishelle.abilityToTrain}") boolean abilityToTrain) {
        Dog mishelle = new Dog(id, type, name, abilityToTrain);
        return mishelle;
    }
}
