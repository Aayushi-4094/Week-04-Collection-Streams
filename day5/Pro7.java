import java.util.Scanner;
import java.util.regex.*;

public class Pro7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = sc.nextLine();
        String regex = "\\bhttps?://(www\\\\.)?([a-zA-Z0-9.-]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted domains :");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


