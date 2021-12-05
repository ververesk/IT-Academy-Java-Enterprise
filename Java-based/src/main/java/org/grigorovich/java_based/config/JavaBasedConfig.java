package org.grigorovich.java_based.config;

import org.grigorovich.java_based.model.Cat;
import org.grigorovich.java_based.model.Dog;
import org.grigorovich.java_based.model.Home;
import org.grigorovich.java_based.model.Owner;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

public class JavaBasedConfig {

    @Bean
    public Cat murka() {
        Cat murka = new Cat(1, "cat", "murka", true);
        return murka;
    }

    @Bean
    public Cat barsik() {
        Cat barsik = new Cat(2, "cat", "barsik", false);
        return barsik;
    }

    @Bean
    public Dog mishelle() {
        Dog mishelle = new Dog(1, "dog", "mishelle", true);
        return mishelle;
    }

    @Bean
    public Owner veronika() {
        Owner veronika = new Owner(1, "veronika", null, null);
        veronika.setListPets(List.of(murka(), mishelle()));
        veronika.setQuarterPetCost(Map.of("I", 70, "II", 85, "III", 90, "IV", 67));
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
    public Home home() {
        Home home = new Home(1, 150, null);
        home.setOwner(veronika());
        return home;
    }
}
