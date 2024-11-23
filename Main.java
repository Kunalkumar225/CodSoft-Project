import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Please choose a number above 0.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Correcting the withdrawal logic
            System.out.println("Withdraw successful of " + amount + " Rs.");
        } else {
            System.out.println("Invalid entry! Insufficient balance or negative value entered.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void display() {
        System.out.println("Select Options:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            display();
            System.out.print("Pick an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance() + " Rs.");
                    break;
                case 4:
                    System.out.println("Thanks for working with Jain Bank.");
                    break;
                default:
                    System.out.println("Invalid entry! Enter only the given options.");
            }
        } while (option != 4);
        sc.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);

        System.out.print("Enter Your PIN: ");
        String pin = sc.nextLine();
        if (pin.equals("1234")) { // Use .equals for string comparison
            atm.run();
        } else {
            System.out.println("Wrong PIN.");
        }

        sc.close(); // Close the scanner
    }
}