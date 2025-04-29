import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pro3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new LinkedList<>();
        
        System.out.println("Enter the size of the list");
        int n = sc.nextInt();
        
        System.out.println("Enter the elements of the list");
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();
            list1.add(l);
        }
        
        System.out.println("Enter the position to be rotated");
        int k = sc.nextInt();
        
        // Handle cases where k is larger than list size
        k = k % n;
        
        // Rotate the list
        rotateElements(list1, 0, n-1);    // Reverse entire list
        rotateElements(list1, 0, k-1);    // Reverse first k elements
        rotateElements(list1, k, n-1);    // Reverse remaining elements
        
        System.out.println("Rotated list: " + list1);
    }
    
    public static void rotateElements(List<Integer> list, int start, int end) {
        while(start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}