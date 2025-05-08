
import java.util.Scanner;

public class Pro8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = sc.nextLine();
        String result = text.replaceAll("\\s+", " ");
        System.out.println(result);    }
    
}
