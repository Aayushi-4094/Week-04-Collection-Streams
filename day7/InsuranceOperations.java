import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return policyNumber + " - " + holderName + " - $" + premiumAmount;
    }
}

public class InsuranceOperations {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "Alice Smith", 1500),
            new InsurancePolicy("P002", "Bob Johnson", 2500),
            new InsurancePolicy("P003", "Charlie Smith", 950),
            new InsurancePolicy("P004", "David White", 1200),
            new InsurancePolicy("P005", "Eve Black", 2000),
            new InsurancePolicy("P006", "Frank Green", 1100),
            new InsurancePolicy("P007", "George Smith", 3000)
        );

        // 1. Filter Policies by Premium Amount > $1,200
        System.out.println("1. Premium > $1,200:");
        policies.stream().filter(p -> p.premiumAmount > 1200).forEach(System.out::println);

        // 2. Sort Policies by Holder Name
        System.out.println("\n2. Sorted by Holder Name:");
        policies.stream().sorted(Comparator.comparing(p -> p.holderName)).forEach(System.out::println);

        // 3. Compute Total Premium
        double totalPremium = policies.stream().mapToDouble(p -> p.premiumAmount).sum();
        System.out.println("\n3. Total Premium: $" + totalPremium);

        // 4. Print Policy Details
        System.out.println("\n4. Formatted Policy Details:");
        policies.forEach(p -> System.out.printf("Policy: %s | Holder: %s | Premium: $%.2f\n", p.policyNumber, p.holderName, p.premiumAmount));

        // 5. Filter by Premium Range (1000 to 2000)
        System.out.println("\n5. Premium between $1,000 and $2,000:");
        policies.stream().filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000).forEach(System.out::println);

        // 6. Highest Premium
        System.out.println("\n6. Policy with Highest Premium:");
        policies.stream().max(Comparator.comparingDouble(p -> p.premiumAmount)).ifPresent(System.out::println);

        // 7. Group by Holder Name Initial
        System.out.println("\n7. Grouped by Initial:");
        Map<Character, List<InsurancePolicy>> grouped = policies.stream().collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
        grouped.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        // 8. Average Premium
        double avgPremium = policies.stream().mapToDouble(p -> p.premiumAmount).average().orElse(0);
        System.out.println("\n8. Average Premium: $" + avgPremium);

        // 9. Sort by Premium and Print
        System.out.println("\n9. Sorted by Premium:");
        policies.stream().sorted(Comparator.comparingDouble(p -> p.premiumAmount)).forEach(System.out::println);

        // 10. Check Premium > $2,000
        boolean anyAbove2000 = policies.stream().anyMatch(p -> p.premiumAmount > 2000);
        System.out.println("\n10. Any policy above $2000: " + anyAbove2000);

        // 11. Count Policies by Premium Range
        System.out.println("\n11. Count by Premium Range:");
        Map<String, Long> premiumRanges = policies.stream().collect(Collectors.groupingBy(
            p -> {
                if (p.premiumAmount <= 1000) return "$0-$1,000";
                else if (p.premiumAmount <= 2000) return "$1,001-$2,000";
                else return ">$2,000";
            }, Collectors.counting()));
        premiumRanges.forEach((range, count) -> System.out.println(range + ": " + count));

        // 12. Unique Holder Names
        System.out.println("\n12. Unique Holder Names:");
        policies.stream().map(p -> p.holderName).distinct().forEach(System.out::println);

        // 13. Find Policies by Name Substring ("Smith")
        System.out.println("\n13. Policies with 'Smith' in name:");
        policies.stream().filter(p -> p.holderName.contains("Smith")).forEach(System.out::println);

        // 14. Map of Policy Number to Premium
        System.out.println("\n14. Policy Number to Premium:");
        Map<String, Double> map = policies.stream().collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));
        map.forEach((k, v) -> System.out.println(k + " -> $" + v));

        // 15. Most Frequent Words from Text Corpus
        System.out.println("\n15. Most Frequent Words:");
        String text = "This is a sample text with some sample words, and this text is just a sample.";
        List<String> words = Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                                   .collect(Collectors.toList());
        Map<String, Long> freq = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        freq.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // 16. Second Most Repeated Word
        System.out.println("\n16. Second Most Repeated Word:");
        List<Map.Entry<String, Long>> sortedWords = new ArrayList<>(freq.entrySet());
        sortedWords.sort(Map.Entry.<String, Long>comparingByValue().reversed());
        if (sortedWords.size() >= 2) {
            System.out.println("Second most repeated word: " + sortedWords.get(1).getKey());
        } else {
            System.out.println("Not enough words");
        }
    }
}
