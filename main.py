class BankAccount:
   def __init__(self, account_name, initial_balance):
       self.name = account_name
       self.balance = initial_balance
       self.EURO_RATE = 0.93
       self.UAH_RATE = 40.47

   def deposit(self, amount):
       if amount > 0:
           self.balance += amount

   def withdraw(self, amount):
       if amount <= self.balance:
           self.balance -= amount
       else:
           raise Exception("You are overdrawn!")

   def convert_to_euro(self):
       print(f"Account: {self.name}\nBalance: €{self.EURO_RATE * self.balance:.2f}")

   def convert_to_uah(self):
       print(f"Account: {self.name}\nBalance: {self.UAH_RATE * self.balance:.2f}₴")

   def display(self):
       print(f"Account: {self.name}\nBalance: ${self.balance:.2f}")


def main():
   name = input("Enter your name: ")
   initial_deposit = float(input("Enter initial deposit ($): "))

   account = BankAccount(name, initial_deposit)

   while True:
       print("\n1. Deposit")
       print("2. Withdraw")
       print("3. Convert To Euro")
       print("4. Convert To UAH")
       print("5. Display Account")
       print("6. Exit")
       choice = int(input("Enter choice: "))

       if choice == 1:
           amount = float(input("Enter deposit amount ($): "))
           account.deposit(amount)
       elif choice == 2:
           amount = float(input("Enter deposit amount ($): "))
           account.withdraw(amount)
       elif choice == 3:
           while True:
               print("\n1. Deposit")
               print("2. Withdraw")
               print("3. Display Account")
               print("4. Exit")
               euro_choice = int(input("Enter choice: "))

               if euro_choice == 1:
                   account.convert_to_euro()
                   amount = float(input("Enter deposit amount (€): "))
                   account.deposit(amount)
               elif euro_choice == 2:
                   account.convert_to_euro()
                   amount = float(input("Enter deposit amount (€): "))
                   account.withdraw(amount)
               elif euro_choice == 3:
                   account.convert_to_euro()
               elif euro_choice == 4:
                   break
       elif choice == 4:
           while True:
               print("\n1. Deposit")
               print("2. Withdraw")
               print("3. Display Account")
               print("4. Exit")
               uah_choice = int(input("Enter choice: "))

               if uah_choice == 1:
                   account.convert_to_uah()
                   amount = float(input("Enter deposit amount (₴): "))
                   account.deposit(amount)
               elif uah_choice == 2:
                   account.convert_to_uah()
                   amount = float(input("Enter deposit amount (₴): "))
                   account.withdraw(amount)
               elif uah_choice == 3:
                   account.convert_to_uah()
               elif uah_choice == 4:
                   break
       elif choice == 5:
           account.display()
       elif choice == 6:
           break


if __name__ == "__main__":
   main()