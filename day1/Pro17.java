import java.util.*;

public class Pro17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter the number of entries: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter key-value pairs (e.g., A 10):");
        for (int i = 0; i < n; i++) {
            String[] pair = scanner.nextLine().split(" ");
            map.put(pair[0], Integer.parseInt(pair[1]));
        }

        String maxKey = findMaxKey(map);
        System.out.println("Key with the highest value: " + maxKey);
    }

    public static String findMaxKey(Map<String, Integer> map) {
        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
