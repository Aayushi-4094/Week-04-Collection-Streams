import java.util.Scanner;
import java.util.regex.*;

public class Pro4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = sc.nextLine();
        String regex = "\\b[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted Email Addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

