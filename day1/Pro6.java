import java.util.*;

public class Pro6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in Set1: ");
        int n1 = scanner.nextInt();
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set1.add(scanner.nextInt());
        }

        System.out.print("Enter number of elements in Set2: ");
        int n2 = scanner.nextInt();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            set2.add(scanner.nextInt());
        }

        System.out.println(set1.equals(set2));
}
}