package calc;

import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    @Test
    public void sum() {
        //given
        List<Integer> integerList=List.of(1,2,3,4);
        int expectedSum = 10;
        //when
        int actualSum = Calculator.sum(integerList);
        //then
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void average() {
        List<Integer> integerList=List.of(1,2,3,4);
        double expectedAverage = 2.5;
        double actualAverage = Calculator.average(integerList);
        assertEquals(expectedAverage, actualAverage,0.0);
    }
}
