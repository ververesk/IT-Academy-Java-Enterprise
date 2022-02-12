package org.grigorovich.java_based.config;

import org.grigorovich.java_based.model.Cat;
import org.grigorovich.java_based.model.Dog;
import org.grigorovich.java_based.model.Owner;
import org.grigorovich.java_based.qualifiers.IgorQualifier;
import org.grigorovich.java_based.qualifiers.VeronikaQualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;
@Configuration
@PropertySource({"classpath:owner.properties"})
public class OwnerConfig {
    @Bean
    @VeronikaQualifier
    public Owner veronika(@Qualifier("murka") Cat cat, Dog mishelle, @Value("${veronika.id}") int id,
                          @Value("${veronika.name}") String name,
                          @Value("#{${veronika.quarterPetCost}}") Map<String, Integer> quarterPetCost
    ) {
        Owner veronika = new Owner(id, name, null, null);
        veronika.setListPets(List.of(cat, mishelle));
        veronika.setQuarterPetCost(quarterPetCost);
        return veronika;
    }

    @Bean
    @IgorQualifier
    public Owner igor(Cat barsik) {
        Owner igor = new Owner(2, "igor", null, null);
        igor.setListPets(List.of(barsik));
        igor.setQuarterPetCost(Map.of("I", 50, "II", 65, "III", 36, "IV", 67));
        return igor;
    }
}
