import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pro15 {
    public static void main(String[] args) throws IOException {        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("myFile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        Map<String, Integer> sorted = new TreeMap<>(wordFrequency);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " = "+ entry.getValue());
        }
    }
}
