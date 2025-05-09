import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        strings.forEach(printUpper);
    }
}
