import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public double getSalary() {
        return salary;
    }

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

class Problem1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 85000),
            new Employee(3, "Charlie", "HR", 70000),
            new Employee(4, "David", "Engineering", 78000)
        );

        Map<String, Double> result = employees.stream()
            .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.averagingDouble(e -> e.salary)
            ));

        System.out.println(result);
    }
}