import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class FinancialTracker {
    public static void main(String[] args) {
        ArrayList<String> transactions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            System.out.println("Financial Transaction Tracker");
            System.out.println("1. Add new transaction");
            System.out.println("2. Yesterday transactions");
            System.out.println("3. Total income and expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter type (Purchase/Sale): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter date (YYYY-MM-DD): ");
                    String dateString = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateString);

                    transactions.add(type + "," + amount + "," + date);
                    System.out.println("Transaction added.");
                    break;
                case 2:
                    LocalDate yesterday = LocalDate.now().minusDays(1);
                    int count = 0;

                    for (String transaction : transactions) {
                        if (transaction.endsWith(yesterday.toString())) {
                            count++;
                        }
                    }

                    System.out.println("Transactions performed yesterday: " + count);
                    break;
                case 3:
                    double salesTotal = 0.0;
                    double purchaseTotal = 0.0;

                    for (String transaction : transactions) {
                        double amount2 = Double.parseDouble(transaction.split(",")[1]);
                        if (transaction.contains("Purchase")) {
                            purchaseTotal += amount2;
                        } else if (transaction.contains("Sale")) {
                            salesTotal += amount2;
                        }
                    }

                    System.out.println("Purchase total: " + purchaseTotal);
                    System.out.println("Sale total: " + salesTotal);
                    break;
                case 4:
                    System.out.println("Exiting program");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }

        }
    }
}