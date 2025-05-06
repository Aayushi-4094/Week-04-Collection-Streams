import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Pro7 {
    public static void main(String[] args) {
        String fileName = "student.dat";

        try (Scanner scanner = new Scanner(System.in);
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            System.out.println("Enter the roll number");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            System.out.println("Enter the name");
            String name = scanner.nextLine();

            System.out.println("Enter the GPA");
            double gpa = scanner.nextDouble();

            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student information saved successfully");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {

            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Student Information:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
