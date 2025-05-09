import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentWords {
    public static void main(String[] args) {
        String text = "Hello world! This is a sample text. Hello again. World of Java and lambda expressions.";

        List<String> words = Arrays.stream(text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Long> wordFreq = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int topN = 3;
        wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
