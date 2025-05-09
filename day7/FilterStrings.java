import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Avocado", "Mango");
        List<String> filtered = list.stream()
                                    .filter(s -> !s.startsWith("A"))
                                    .collect(Collectors.toList());
        System.out.println(filtered);
    }
}