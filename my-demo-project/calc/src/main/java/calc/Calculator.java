package calc;

import java.util.List;

public final class Calculator {
private static volatile Calculator instance;

private Calculator(){

}

public static Calculator getInstance() {
    if (instance==null)
        synchronized (Calculator.class) {
            if (instance==null)
                instance=new Calculator();
        }
    return instance;
}

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
