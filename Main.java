import java.util.Scanner;

class BankAccount {
    private String name;
    private double balance;
    private double EURO_RATE = 0.93;
    private double UAH_RATE = 40.47;

    public BankAccount(String accountName, double initialBalance) {
        this.name = accountName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
        else {
            throw new Error("You are overdrawn!");
        }
    }

    public void convertToEuro(double amount) {
        System.out.println("Account: " + name + "\nBalance: €" + (EURO_RATE * balance));
    }

    public void convertToUAH(double amount) {
        System.out.println("Account: " + name + "\nBalance: " + (UAH_RATE * balance) + "₴");
    }

    public void display(double amount) {
        System.out.println("Account: " + name + "\nBalance: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit ($): ");
        double initialDeposit = scanner.nextDouble();

        BankAccount account = new BankAccount(name, initialDeposit);

        int choice;
        double amount = 0.0;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Convert To Euro");
            System.out.println("4. Convert To UAH");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount ($): ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount ($): ");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;
                case 3:
                    do {
                        System.out.println("\n1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Display Account");
                        System.out.println("4. Exit");
                        System.out.print("Enter choice: ");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                account.convertToEuro(amount);
                                System.out.print("Enter deposit amount (€): ");
                                amount = scanner.nextDouble();
                                account.deposit(amount);
                                break;
                            case 2:
                                account.convertToEuro(amount);
                                System.out.print("Enter deposit amount (€): ");
                                amount = scanner.nextDouble();
                                account.withdraw(amount);
                                break;
                            case 3:
                                account.convertToEuro(amount);
                                break;
                            case 4:
                                break;
                        }
                    } while (choice != 4);
                    break;
                case 4:
                    do {
                        System.out.println("\n1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Display Account");
                        System.out.println("4. Exit");
                        System.out.print("Enter choice: ");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                account.convertToUAH(amount);
                                System.out.print("Enter deposit amount (₴): ");
                                amount = scanner.nextDouble();
                                account.deposit(amount);
                                break;
                            case 2:
                                account.convertToUAH(amount);
                                System.out.print("Enter deposit amount (₴): ");
                                amount = scanner.nextDouble();
                                account.withdraw(amount);
                                break;
                            case 3:
                                account.convertToUAH(amount);
                                break;
                            case 4:
                                break;
                        }
                    } while (choice != 4);
                    break;
                case 5:
                    account.display(amount);
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}