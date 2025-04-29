import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Pro19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter employee details (e.g., Alice HR):");
        for (int i = 0; i < n; i++) {
            String[] details = scanner.nextLine().split(" ");
            employees.add(new Employee(details[0], details[1]));
        }

        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        System.out.println("Employees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedEmployees = new HashMap<>();
        for (Employee employee : employees) {
            groupedEmployees.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }
        return groupedEmployees;
    }
}
