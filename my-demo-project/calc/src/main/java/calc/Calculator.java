package calc;

import java.util.List;

public final class Calculator {
    /**
     * сделала Calculator синглтоном, подумала не имеет смысл делать много экземпляров класса
     */
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

    /**
     * метод average есть, но он нигде не задействован
     * @param ints
     * @return
     */
    public static double average(List<Integer> ints) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }
}
