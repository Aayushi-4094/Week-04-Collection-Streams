import java.util.Scanner;
import java.util.regex.*;

public class Pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the license plate number");
        String license = sc.nextLine();
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(license);
        if (matcher.matches()) {
            System.out.println("Valid license");
        } else {
            System.out.println("Invalid license");
        }
    }
}


