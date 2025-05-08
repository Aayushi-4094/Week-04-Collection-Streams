import java.util.Scanner;
import java.util.regex.*;

public class Pro11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the credit card number");
        String cardNumber = sc.nextLine();
        String regex = "^(4|5)[0-9]{15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        if (matcher.matches()) {
            if (cardNumber.startsWith("4")) {
                System.out.println("Valid Visa card number");
            } else {
                System.out.println("Valid MasterCard number");
            }
        } else {
            System.out.println("Invalid credit card number");
        }
    }
}
