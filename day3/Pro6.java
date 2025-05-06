
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Pro6 {
    public static void main(String[] args) {
        try (
            BufferedReader br = new BufferedReader(new FileReader("output2.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("toLowercase.txt"))
        ){
            String line;
            while((line = br.readLine()) != null){
                for (char ch : line.toCharArray()) {
                    bw.write(Character.toLowerCase(ch));
                    bw.newLine();
                }
            }
            System.out.println("File copied successfully");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
