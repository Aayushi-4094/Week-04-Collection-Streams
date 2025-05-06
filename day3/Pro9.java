import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pro9 {
    public static void main(String[] args) {
        String fileName = "ResearchManual.docx";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


