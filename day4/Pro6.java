import java.util.Scanner;

public class Pro6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount");
        double amount = sc.nextDouble();
        System.out.println("Enter rate");
        double rate = sc.nextDouble();
        System.out.println("Enter time in years");
        int years = sc.nextInt();
        try {
            calculateInterest(amount, rate, years);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }

    public static void calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (rate <= 0 || amount < 0) {
            throw new IllegalArgumentException();
        } else {
            double compoundInterest = (amount * Math.pow((1 + rate / 100), years)) - amount;
            System.out.println("Compound interest is " + compoundInterest);
        }
    }
}

