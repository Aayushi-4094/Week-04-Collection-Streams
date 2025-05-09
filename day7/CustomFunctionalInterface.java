@FunctionalInterface
interface Square {
    int calculate(int x);

    default void printResult(int x) {
        System.out.println("Square of " + x + " is: " + calculate(x));
    }
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        Square square = n -> n * n;
        square.printResult(6);
    }
}