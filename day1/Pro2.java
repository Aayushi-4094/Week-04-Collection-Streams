import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pro2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> hashMap = new HashMap<>();
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            String s = sc.nextLine();

            if (hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s) + 1);
            } else {
                hashMap.put(s, 1);
            }
        }

        System.out.println("Frequency of elements: " + hashMap);
    }

}