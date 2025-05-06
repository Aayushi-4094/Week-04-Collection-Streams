import java.util.InputMismatchException;
import java.util.Scanner;

public class Pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = getNumber(sc, "Enter the first number");
        int b = getNumber(sc, "Enter the second number");
        try {
            divide(a, b);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    public static int getNumber(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException caught: Please enter a valid number");
                sc.next(); // Clear invalid input
            }
        }
    }

    public static void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        System.out.println("Result: " + (a / b));
    }
}
