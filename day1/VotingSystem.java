import java.util.*;

class VotingSystem {
    private Map<String, Integer> votes;
    private Map<String, Integer> voteOrder;

    public VotingSystem() {
        this.votes = new HashMap<>();
        this.voteOrder = new LinkedHashMap<>();
    }

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        Map<String, Integer> sortedVotes = new TreeMap<>((a, b) -> votes.get(b).compareTo(votes.get(a)));
        sortedVotes.putAll(votes);

        System.out.println("Voting Results (Sorted by Votes):");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        System.out.println("\nVoting Order:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cast Vote");
            System.out.println("2. Display Results");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidate = scanner.nextLine();
                    votingSystem.castVote(candidate);
                    break;
                case 2:
                    votingSystem.displayResults();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

