import java.util.*;

public class Pro12 {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> binaryNumbers = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");
        while (binaryNumbers.size() < n) {
            String current = queue.poll();
            binaryNumbers.add(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return binaryNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        List<String> binaryNumbers = generateBinaryNumbers(n);
        System.out.println("First " + n + " binary numbers: " + binaryNumbers);
    }
}

