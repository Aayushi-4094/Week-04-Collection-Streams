import java.util.Scanner;
import java.util.regex.*;


public class Pro3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the color");
        String colour = sc.nextLine();
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(colour);
        if (matcher.matches()) {
            System.out.println("Valid color");
        } else {
            System.out.println("Invalid color");
        }
    }
}
