
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Pro4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        System.out.println("Enter the numbr of elements in the array");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        System.out.println("Original list: " + list);

        List<Integer> uniqueList = new LinkedList<>();
        for (Integer num : list) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }

        System.out.println("List without duplicates: " + uniqueList);
    }
}
