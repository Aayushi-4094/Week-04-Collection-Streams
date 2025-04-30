import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts;
    private Queue<WithdrawalRequest> withdrawalQueue;

    public BankingSystem() {
        this.accounts = new HashMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
            System.out.println("Deposit successful. New balance: " + accounts.get(accountNumber));
        } else {
            System.out.println("Account not found!");
        }
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request added to queue.");
        } else {
            System.out.println("Account not found!");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            String accountNumber = request.getAccountNumber();
            double amount = request.getAmount();

            if (accounts.get(accountNumber) >= amount) {
                double currentBalance = accounts.get(accountNumber);
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal successful. New balance: " + accounts.get(accountNumber));
            } else {
                System.out.println("Insufficient funds!");
            }
        }
    }

    public void displayAccountsByBalance() {
        Map<String, Double> sortedAccounts = new TreeMap<>((a, b) -> accounts.get(b).compareTo(accounts.get(a)));
        sortedAccounts.putAll(accounts);

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static class WithdrawalRequest {
        private String accountNumber;
        private double amount;

        public WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        bankingSystem.createAccount("12345", 1000.0);
        bankingSystem.createAccount("67890", 500.0);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Request withdrawal");
            System.out.println("3. Process withdrawals");
            System.out.println("4. Display accounts by balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    bankingSystem.deposit(accountNumber, depositAmount);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    bankingSystem.requestWithdrawal(accountNumber, withdrawalAmount);
                    break;
                case 3:
                    bankingSystem.processWithdrawals();
                    break;
                case 4:
                    bankingSystem.displayAccountsByBalance();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}


