import java.io.*;
import java.nio.file.*;

public class Pro5 {
    public static void main(String[] args) {
        String inputFile = "me.jpg"; 
        String outputFile = "newMe.jpg";

        try {
            if (!Files.exists(Paths.get(inputFile))) {
                System.out.println("Error: Input file '" + inputFile + "' not found in:");
                System.out.println(System.getProperty("user.dir"));
                return;
            }

            long startTime = System.currentTimeMillis();

            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(outputFile)) {

                byte[] buffer = new byte[8192]; 
                int bytesRead;
                
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Image copied successfully in " + (endTime - startTime) + " ms");
            System.out.println("New file created: " + new File(outputFile).getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}