import java.util.List;

public final class Calculator {
    private Calculator() {

    }
    public static int sum(List<Integer> ints) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
