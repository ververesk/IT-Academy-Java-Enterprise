package org.grigorovich.java_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grigorovich.java_based.qualifiers.VeronikaQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@PropertySource("classpath:home.properties")
public class Home {
    @Value("${veronikaHome.id}")
    private int id;
    @Value("${veronikaHome.square}")
    private int square;
    @Autowired
    @VeronikaQualifier //указала какой именно бин нам нужен
    private Owner owner;

    public Home(int id, int square) {
        this.id = id;
        this.square = square;
    }


}
