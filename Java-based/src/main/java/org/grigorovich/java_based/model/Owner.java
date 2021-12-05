package org.grigorovich.java_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    private int id;
    private String name;
    private List<? extends Pet> listPets;
    private Map<String, Integer> quarterPetCost;
}
