package org.grigorovich.java_based.config;

import org.grigorovich.java_based.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;


import java.util.List;
import java.util.Map;
@PropertySource({"classpath:cat.properties", "classpath:owner.properties", "classpath:dog.properties"})
public class JavaBasedConfig {

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

    @Bean
    public Dog mishelle(@Value("${mishelle.id}") int id, @Value("${mishelle.type}") String type,
                        @Value("${mishelle.name}") String name, @Value("${mishelle.abilityToTrain}") boolean abilityToTrain) {
        Dog mishelle = new Dog(id, type, name, abilityToTrain);
        return mishelle;
    }


    @Bean
    public Owner veronika(Cat murka, Dog mishelle, @Value("${veronika.id}") int id,
                         @Value("${veronika.name}") String name,
                         @Value("#{${veronika.quarterPetCost}}") Map<String, Integer> quarterPetCost
    ) {
        Owner veronika = new Owner(id, name, null, null);
        veronika.setListPets(List.of(murka, mishelle));
        veronika.setQuarterPetCost(quarterPetCost);
        return veronika;
    }

    @Bean
    public Owner igor() {
        Owner igor = new Owner(2, "igor", null, null);
        igor.setListPets(List.of(barsik()));
        igor.setQuarterPetCost(Map.of("I", 50, "II", 65, "III", 36, "IV", 67));
        return igor;
    }

    @Bean
    public Home home(Owner veronika) {
        Home home = new Home(1, 150, null);
        home.setOwner(veronika);
        return home;
    }
}
