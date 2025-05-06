
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

 public class Pro2{
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("ResearchManual.docx"));
        BufferedOutputStream bio = new BufferedOutputStream(new FileOutputStream("ResearchManualOutput.txt"))
        ){
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = bis.read(buffer)) != -1){
                bio.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully with buffering.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 }