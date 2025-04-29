import java.util.*;

public class Pro18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        System.out.print("Enter the number of entries for Map 1: ");
        int n1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter key-value pairs for Map 1 (e.g., A 1):");
        for (int i = 0; i < n1; i++) {
            String[] pair = scanner.nextLine().split(" ");
            map1.put(pair[0], Integer.parseInt(pair[1]));
        }

        Map<String, Integer> map2 = new HashMap<>();
        System.out.print("Enter the number of entries for Map 2: ");
        int n2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter key-value pairs for Map 2 (e.g., B 3):");
        for (int i = 0; i < n2; i++) {
            String[] pair = scanner.nextLine().split(" ");
            map2.put(pair[0], Integer.parseInt(pair[1]));
        }

        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        System.out.println("Merged Map:");
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.put(entry.getKey(), mergedMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        return mergedMap;
    }
}
