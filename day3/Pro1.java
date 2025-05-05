import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pro1 {
    public static void main(String[] args) {
        String sourceFile = "notes.txt";
        String destinationFile = "Output.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int letters;
            while ((letters = fis.read()) != -1) {
                fos.write(letters);
            }

            System.out.println("File copied successfully");

        } catch (IOException e) {
            if (e.getMessage().contains("No such file or directory")) {
                System.out.println("Source file does not exist");
            } else {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
