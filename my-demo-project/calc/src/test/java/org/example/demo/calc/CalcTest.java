package org.example.demo.calc;

import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    @Test
    public void averageMarkOfStudent() {
        //given
        List<Integer> integerList=List.of(1,2,3,4,5);
        double expectedAverage = 3.0;
        //when
        double actualAverage = Calculator.averageMarkOfStudent(integerList);
        //then
        assertEquals(expectedAverage, actualAverage,0.0);
    }

    @Test
    public void averageSalaryOfTeachers() {
        List<Double> doubleList=List.of(1.0,2.5,3.9,4.6);
        double expectedAverage = 3.0;
        double actualAverage = Calculator.averageSalaryOfTeachers(doubleList);
        assertEquals(expectedAverage, actualAverage,0.0);
    }
}
