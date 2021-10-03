package calc;

import java.util.List;

public final class Calculator {


    public static int sum(List<Integer> ints) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double average(List<Integer> ints) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }
}
