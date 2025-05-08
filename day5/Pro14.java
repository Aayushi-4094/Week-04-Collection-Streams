import java.util.Scanner;

public class Pro14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = sc.nextLine().toLowerCase();
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(words[i + 1])) {
                System.out.println("Repeating word: " + words[i]);
            }
        }
    }
}

