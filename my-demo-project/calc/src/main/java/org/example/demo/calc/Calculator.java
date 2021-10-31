package org.example.demo.calc;

import java.util.List;

public final class Calculator {

    private Calculator() {
        //private constructor
    }


    public static double averageMarkOfStudent(List<Integer> ints) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public static double averageSalaryOfTeachers(List<Double> ints) {
        return ints.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
    }
}
