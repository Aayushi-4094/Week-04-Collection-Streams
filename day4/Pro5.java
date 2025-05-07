
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pro5 {
    public static void main(String[] args) {
        String line = null;
        try (
            BufferedReader br = new BufferedReader(new FileReader("info.txt"))
        ){
            line = br.readLine();
        //System.out.println(line); 
            
        } catch (IOException e) {
            System.out.println("Error reading the file" +e.getMessage());
        }
        if (line != null) {
            System.out.println("First line: " + line);
        } else {
            System.out.println("The file is empty or an error occurred.");
        }
    }
}
