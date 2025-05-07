import java.util.Scanner;
import java.util.regex.*;

public class Pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter a username");
        String username = sc.next();
        Matcher matcher = pattern.matcher(username);
        if (matcher.matches()) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
    }
}
