package org.grigorovich.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grigorovich.spring.qualifiers.IgorQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {
    private int id;
    private int square;
    @Autowired
 //   @Qualifier("123")
    @IgorQualifier
    private Owner owner;
 //   private Owner igor;

    public Home(int id, int square) {
        this.id = id;
        this.square = square;
    }


}
