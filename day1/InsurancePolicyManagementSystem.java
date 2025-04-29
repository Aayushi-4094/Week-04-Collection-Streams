import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem {
    private Set<InsurancePolicy> hashSet;
    private Set<InsurancePolicy> linkedHashSet;
    private Set<InsurancePolicy> treeSet;

    public InsurancePolicyManagementSystem() {
        this.hashSet = new HashSet<>();
        this.linkedHashSet = new LinkedHashSet<>();
        this.treeSet = new TreeSet<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void retrievePolicies() {
        System.out.println("All unique policies (HashSet): " + hashSet);
        System.out.println("Policies in order of insertion (LinkedHashSet): " + linkedHashSet);
        System.out.println("Policies sorted by expiry date (TreeSet): " + treeSet);
    }

    public void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate soon = today.plusDays(30);
        Set<InsurancePolicy> expiringSoon = new HashSet<>();
        for (InsurancePolicy policy : treeSet) {
            if (!policy.getExpiryDate().isAfter(soon)) {
                expiringSoon.add(policy);
            }
        }
        System.out.println("Policies expiring soon: " + expiringSoon);
    }

    public void policiesByCoverageType(String coverageType) {
        Set<InsurancePolicy> policies = new HashSet<>();
        for (InsurancePolicy policy : hashSet) {
            if (policy.getCoverageType().equals(coverageType)) {
                policies.add(policy);
            }
        }
        System.out.println("Policies with coverage type '" + coverageType + "': " + policies);
    }

    public void performanceComparison() {
        long startTime, endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(new InsurancePolicy(String.valueOf(i), "Name", LocalDate.now(), "Type", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet add time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.add(new InsurancePolicy(String.valueOf(i), "Name", LocalDate.now(), "Type", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(new InsurancePolicy(String.valueOf(i), "Name", LocalDate.now(), "Type", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet add time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        InsurancePolicy policy1 = new InsurancePolicy("123", "John Doe", LocalDate.of(2024, 12, 31), "Health", 500.0);
        InsurancePolicy policy2 = new InsurancePolicy("456", "Jane Doe", LocalDate.of(2024, 6, 30), "Auto", 300.0);
        InsurancePolicy policy3 = new InsurancePolicy("789", "Bob Smith", LocalDate.of(2024, 3, 31), "Home", 800.0);

        system.addPolicy(policy1);
        system.addPolicy(policy2);
        system.addPolicy(policy3);

        system.retrievePolicies();
        system.policiesExpiringSoon();
        system.policiesByCoverageType("Health");
        system.performanceComparison();
}
}
