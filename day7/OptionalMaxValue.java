import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalMaxValue {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(); // Try with numbers too

        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.println("Max value: " + max.orElse(-1));
    }
}
