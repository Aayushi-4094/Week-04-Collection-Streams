import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    PriorityQueue<Patient> patients;

    public HospitalTriageSystem() {
        patients = new PriorityQueue<>();
    }

    public void addPatient(Patient patient) {
        patients.offer(patient);
    }

    public void treatPatients() {
        while (!patients.isEmpty()) {
            Patient patient = patients.poll();
            System.out.println("Treating patient: " + patient);
        }
    }

    public static void main(String[] args) {
        HospitalTriageSystem triageSystem = new HospitalTriageSystem();

        triageSystem.addPatient(new Patient("John", 3));
        triageSystem.addPatient(new Patient("Alice", 5));
        triageSystem.addPatient(new Patient("Bob", 2));

        System.out.println("Triage Order:");
        triageSystem.treatPatients();
    }
}
