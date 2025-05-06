import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pro2 {
    public static void main(String[] args) {
        String sourceFile = "ResearchManual.docx";
        String destinationFileBuffered = "ResearchManualOutputBuffered.txt";
        String destinationFileUnbuffered = "ResearchManualOutputUnbuffered.txt";

        long startTimeBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        long endTimeBuffered = System.nanoTime();
        long executionTimeBuffered = endTimeBuffered - startTimeBuffered;
        System.out.println("File copied successfully with buffering in " + executionTimeBuffered + " nanoseconds");

        long startTimeUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        long endTimeUnbuffered = System.nanoTime();
        long executionTimeUnbuffered = endTimeUnbuffered - startTimeUnbuffered;
        System.out.println("File copied successfully without buffering in " + executionTimeUnbuffered + " nanoseconds");
        System.out.println("Buffered stream execution time: " + executionTimeBuffered + " nanoseconds");
        System.out.println("Unbuffered stream execution time: " + executionTimeUnbuffered + " nanoseconds");
        if (executionTimeBuffered < executionTimeUnbuffered) {
            System.out.println("Buffered streams are faster");
        } else {
            System.out.println("Unbuffered streams are faster");
        }
    }
}
