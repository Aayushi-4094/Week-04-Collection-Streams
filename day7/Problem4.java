import java.util.Arrays;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
    String claimId, policyNumber, status;
    double claimAmount;
    Date claimDate;

    Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class Problem4 {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C1", "P1", 10000, new Date(), "Approved"),
            new Claim("C2", "P2", 8000, new Date(), "Approved"),
            new Claim("C3", "P1", 6000, new Date(), "Approved"),
            new Claim("C4", "P2", 4000, new Date(), "Rejected")
        );

        Map<String, DoubleSummaryStatistics> stats = claims.stream()
            .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(
                c -> c.policyNumber,
                Collectors.summarizingDouble(c -> c.claimAmount)
            ));

        stats.entrySet().stream()
            .sorted((a, b) -> Double.compare(b.getValue().getSum(), a.getValue().getSum()))
            .limit(3)
            .forEach(e -> System.out.println(e.getKey() + ": Total=" + e.getValue().getSum() + ", Avg=" + e.getValue().getAverage()));
    }
}