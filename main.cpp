#include <iostream>
#include <string>

class BankAccount {
    private:
        std::string name;
        double balance;

    public:
        BankAccount(std::string accountName, double initialBalance) : name(std::move(accountName)), balance(initialBalance) {}

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            }
        }

        void convertToEuro(double amount) {
            std::cout << "Account: " << name << "\nBalance: €" << 0.92 * balance << std::endl;
        }

        void convertToUAH(double amount) {
            std::cout << "Account: " << name << "\nBalance: " << 38.78 * balance << "₴" << std::endl;
        }

        void display(double amount) {
            std::cout << "Account: " << name << "\nBalance: $" << balance << std::endl;
        }
};

int main() {
    std::string name;
    double initialDeposit;

    std::cout << "Enter your name: ";
    getline(std::cin, name);

    std::cout << "Enter initial deposit ($): ";
    std::cin >> initialDeposit;

    BankAccount account(name, initialDeposit);

    int choice;
    double amount;

    do {
        std::cout << "\n1. Deposit" << std::endl;
        std::cout << "2. Withdraw" << std::endl;
        std::cout << "3. Convert To Euro" << std::endl;
        std::cout << "4. Convert To UAH" << std::endl;
        std::cout << "5. Display Account" << std::endl;
        std::cout << "6. Exit" << std::endl;
        std::cout << "Enter choice: ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                std::cout << "Enter deposit amount ($): ";
                std::cin >> amount;
                account.deposit(amount);
                break;
            case 2:
                std::cout << "Enter deposit amount ($): ";
                std::cin >> amount;
                account.withdraw(amount);
                break;
            case 3:
                do {
                    std::cout << "\n1. Deposit" << std::endl;
                    std::cout << "2. Withdraw" << std::endl;
                    std::cout << "3. Display Account" << std::endl;
                    std::cout << "4. Exit" << std::endl;
                    std::cout << "Enter choice: ";
                    std::cin >> choice;

                    switch (choice) {
                        case 1:
                            account.convertToEuro(amount);
                            std::cout << "Enter deposit amount (€): ";
                            std::cin >> amount;
                            account.deposit(amount);
                            break;
                        case 2:
                            account.convertToEuro(amount);
                            std::cout << "Enter deposit amount (€): ";
                            std::cin >> amount;
                            account.withdraw(amount);
                            break;
                        case 3:
                            account.convertToEuro(amount);
                            break;
                        case 4:
                            break;
                    };
                } while (choice != 4);

            case 4:
                do {
                    std::cout << "\n1. Deposit" << std::endl;
                    std::cout << "2. Withdraw" << std::endl;
                    std::cout << "3. Display Account" << std::endl;
                    std::cout << "4. Exit" << std::endl;
                    std::cout << "Enter choice: ";
                    std::cin >> choice;

                    switch (choice) {
                        case 1:
                            account.convertToUAH(amount);
                            std::cout << "Enter deposit amount (₴): ";
                            std::cin >> amount;
                            account.deposit(amount);
                            break;
                        case 2:
                            account.convertToUAH(amount);
                            std::cout << "Enter deposit amount (₴): ";
                            std::cin >> amount;
                            account.withdraw(amount);
                            break;
                        case 3:
                            account.convertToUAH(amount);
                            break;
                        case 4:
                            break;
                    };
                } while (choice != 4);

            case 5:
                account.display(amount);
                break;
            case 6:
                break;
        };
    } while (choice != 6);

    return 0;
};



