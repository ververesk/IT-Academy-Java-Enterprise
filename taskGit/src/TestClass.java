public class TestClass {
    public static void main(String[] args) {
        System.out.println(square());
        System.out.println(cube());
    }
    private static int square() {
        return 2*2;
    }

    private static int cube() {
        System.out.println("Bye");
        return 4*4*4;
    }
}
