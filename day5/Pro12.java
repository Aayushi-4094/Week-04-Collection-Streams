import java.util.Scanner;
import java.util.regex.*;

public class Pro12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = sc.nextLine();
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted programming languages:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
