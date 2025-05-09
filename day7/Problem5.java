import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId, name, policyType;
    int age;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId, name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
}

class Problem5 {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H1", "Alice", 65, "Life", 40000),
            new PolicyHolder("H2", "Bob", 70, "Life", 30000),
            new PolicyHolder("H3", "Charlie", 55, "Health", 20000)
        );

        Map<String, List<RiskAssessment>> categorized = holders.stream()
            .filter(h -> h.policyType.equals("Life") && h.age > 60)
            .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
            .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
            .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        categorized.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(r -> System.out.println(r.holderId + " - " + r.riskScore));
        });
    }
}
