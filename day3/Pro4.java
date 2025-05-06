import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Pro4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numEmployees; i++) {
            System.out.print("Enter employee " + (i + 1) + " ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter employee " + (i + 1) + " name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee " + (i + 1) + " department: ");
            String department = scanner.nextLine();

            System.out.print("Enter employee " + (i + 1) + " salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over

            employees.add(new Employee(id, name, department, salary));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully");
        } catch (IOException e) {
            System.out.println("An error occurred during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee employee : deserializedEmployees) {
                System.out.println(employee);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred during deserialization: " + e.getMessage());
        }
    }
}

