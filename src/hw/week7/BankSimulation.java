package hw.week7;

import java.util.HashMap;
import java.util.NoSuchElementException;

class Account {
    private String username;
    private String password;
    private double balance;

    Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    Account(String username, String password) {
        this(username, password, 0);
    }

    double getBalance() {
        System.out.println(username + "'s balance is " + balance + '.');
        return balance;
    }

    void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be a positive number.");
        else {
            this.balance += amount;
            System.out.println(username + "'s balance is " + balance + " after depositing " + amount + ".");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be a positive number.");
        else if (amount > balance)
            throw new IllegalArgumentException("Balance not sufficient.");
        else {
            balance -= amount;
            System.out.println(username + "'s balance is " + balance + " after withdrawing " + amount + ".");
        }
    }
}

class Bank {
    private String bankName;
    private HashMap<String, Account> users;

    Bank(String bankName) {
        this.bankName = bankName;
        users = new HashMap <>();
    }

    void openAccount(String username, String password, double initialBalance) {
        if (users.containsKey(username))
            throw new IllegalArgumentException("This username is already taken.");
        else users.put(username, new Account(username, password, initialBalance));
    }

    void openAccount(String username, String password) {
        this.openAccount(username, password, 0);
    }

    double queryBalance(String username) {
        if (!users.containsKey(username))
            throw new NoSuchElementException("User not found.");
        else
            return users.get(username).getBalance();
    }

    void deposit(String username, double amount) {
        if (!users.containsKey(username))
            throw new NoSuchElementException("User not found.");
        else
            users.get(username).deposit(amount);
    }

    void withdraw(String username, double amount) {
        if (!users.containsKey(username))
            throw new NoSuchElementException("User not found.");
        else
            users.get(username).withdraw(amount);
    }

}

public class BankSimulation {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank of China");

        bank.openAccount("Alice", "AlicePsw", 400);
        bank.openAccount("Bob", "BobPsw", 4000);
        bank.deposit("Alice", 400);
        bank.withdraw("Bob", 300);
        bank.openAccount("Carol", "CarolPsw", 600);
        bank.queryBalance("Carol");
    }
}
