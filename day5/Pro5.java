
import java.util.Scanner;
import java.util.regex.*;

public class Pro5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = sc.nextLine();
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted Capitalized Words:");
        while (matcher.find()) {
            System.out.print(matcher.group());
        }
    }
}


