import java.io.*;
import java.util.*;

public class SimpleBankingSystem {
    private static final String FILE_NAME = "accounts.txt";
    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        loadAccounts();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSimple Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.nextLine();
                    createAccount(name);
                    break;
                case 2:
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(name, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(name, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine();
                    checkBalance(name);
                    break;
                case 5:
                    saveAccounts();
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void createAccount(String name) {
        if (accounts.containsKey(name)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(name, 0.0);
            System.out.println("Account created successfully.");
        }
    }

    private static void deposit(String name, double amount) {
        if (accounts.containsKey(name)) {
            double newBalance = accounts.get(name) + amount;
            accounts.put(name, newBalance);
            System.out.println("Deposited " + amount + ". New balance: " + newBalance);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static void withdraw(String name, double amount) {
        if (accounts.containsKey(name)) {
            double currentBalance = accounts.get(name);
            if (amount <= currentBalance) {
                double newBalance = currentBalance - amount;
                accounts.put(name, newBalance);
                System.out.println("Withdrew " + amount + ". New balance: " + newBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static void checkBalance(String name) {
        if (accounts.containsKey(name)) {
            double balance = accounts.get(name);
            System.out.println("Account balance: " + balance);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static void loadAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double balance = Double.parseDouble(parts[1]);
                accounts.put(name, balance);
            }
        } catch (IOException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }

    private static void saveAccounts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, Double> entry : accounts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save data.");
        }
    }
}
