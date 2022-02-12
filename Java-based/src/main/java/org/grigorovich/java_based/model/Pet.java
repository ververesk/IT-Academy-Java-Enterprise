package org.grigorovich.java_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pet implements Animal{
    protected int id;
    protected String type;
    protected String name;
}
