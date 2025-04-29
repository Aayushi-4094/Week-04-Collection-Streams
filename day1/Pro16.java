import java.util.*;

public class Pro16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> originalMap = new HashMap<>();

        System.out.print("Enter the number of entries: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter key-value pairs (e.g., A 1):");
        for (int i = 0; i < n; i++) {
            String[] pair = scanner.nextLine().split(" ");
            originalMap.put(pair[0], Integer.parseInt(pair[1]));
        }

        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        System.out.println("Inverted Map:");
        for (Map.Entry<Integer, List<String>> entry : invertedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> originalMap) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return invertedMap;
    }
}

