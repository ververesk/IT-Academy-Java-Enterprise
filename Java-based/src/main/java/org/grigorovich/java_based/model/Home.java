package org.grigorovich.java_based.model;

import lombok.*;
import org.grigorovich.java_based.qualifiers.VeronikaQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;


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
    //  @Autowired
    //  @VeronikaQualifier ну или такой вариант
    //   @Qualifier("igor") //указала какой именно бин нам нужен
    private Owner owner;

    @Autowired
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Map<String, Owner> ownerMap;

    @Value("${veronikaHome.owner}")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String ownerName;


    public Home(int id, int square) {
        this.id = id;
        this.square = square;
    }
//Autowiring by setters
//    @Autowired
//    @Qualifier("igor")
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }

    //Autowiring by constructor
//    @Autowired
//    public Home(@Qualifier("veronika") Owner owner) {
//        this.owner = owner;
//    }

    @PostConstruct
    public void start() {
        owner = ownerMap.get(ownerName);
        System.out.println(this.getClass().getSimpleName() + ": init method");
    }


    @PreDestroy
    public void finish() {
        System.out.println(this.getClass().getSimpleName() + ": destroy method");
    }
}
