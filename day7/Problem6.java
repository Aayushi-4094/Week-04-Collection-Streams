import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    String transactionId, policyNumber;
    double amount;
    Date transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, Date date, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = date;
        this.isFraudulent = isFraudulent;
    }
}

class Problem6 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "P1", 15000, new Date(), true),
            new Transaction("T2", "P1", 20000, new Date(), true),
            new Transaction("T3", "P1", 18000, new Date(), true),
            new Transaction("T4", "P1", 22000, new Date(), true),
            new Transaction("T5", "P1", 3000, new Date(), true),
            new Transaction("T6", "P1", 9000, new Date(), true),
            new Transaction("T7", "P2", 60000, new Date(), true)
        );

        Map<String, List<Transaction>> grouped = transactions.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.groupingBy(t -> t.policyNumber));

        grouped.entrySet().stream()
            .filter(e -> e.getValue().size() > 5 || e.getValue().stream().mapToDouble(t -> t.amount).sum() > 50000)
            .forEach(e -> System.out.println("Alert: " + e.getKey()));
    }
}
