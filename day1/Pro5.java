import java.util.LinkedList;
import java.util.Scanner;

public class Pro5 {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Enter the number of elements in the list:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline left-over

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        System.out.println("Enter the value of N (Nth element from the end):");
        int nth = sc.nextInt();

        String result = findNthFromEnd(list, nth);
        if (result != null) {
            System.out.println("The " + nth + "th element from the end is: " + result);
        } else {
            System.out.println("N is greater than the length of the list.");
        }
    }

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (n <= 0 || n > list.size()) {
            return null;
        }

        return list.get(list.size() - n);
    }
}

