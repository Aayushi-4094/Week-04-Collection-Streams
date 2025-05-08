import java.util.Scanner;
import java.util.regex.Pattern;

public class Pro9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = sc.nextLine();
        String[] badWords = {"damn", "idiot", "imbecile", "stupid"}; 
        for (String word : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + Pattern.quote(word) + "\\b", "****");
        }
        System.out.println("Censored Sentence: " + sentence);
    }

}
