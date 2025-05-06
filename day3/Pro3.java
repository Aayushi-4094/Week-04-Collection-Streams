import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro3 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output2.txt"))) {

            System.out.println("Enter the name");
            String name = br.readLine();

            System.out.println("Enter the age");
            int age = Integer.parseInt(br.readLine());

            System.out.println("Enter the favourite programming language");
            String favLanguage = br.readLine();

            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Age: " + age);
            bw.newLine();
            bw.write("Favourite Programming Language: " + favLanguage);
            bw.newLine();

            System.out.println("User information saved successfully");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format");
        }
    }
}

