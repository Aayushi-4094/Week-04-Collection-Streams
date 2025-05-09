import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMostRepeatWord {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple mango banana mango";

        Map<String, Long> freqMap = Arrays.stream(text.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> sorted = freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        if (sorted.size() < 2) {
            System.out.println("Not enough distinct words.");
        } else {
            Map.Entry<String, Long> second = sorted.get(1);
            System.out.println("Second most frequent word: " + second.getKey() + " (count: " + second.getValue() + ")");
        }
    }
}
