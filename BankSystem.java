package Calc;

import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----- Savings Account -----");
        SavingsAccount sa = new SavingsAccount(1000);

        System.out.print("Enter deposit amount for Savings: ");
        double dep1 = sc.nextDouble();
        sa.deposit(dep1);

        System.out.print("Enter withdrawal amount for Savings: ");
        double wit1 = sc.nextDouble();
        sa.withdraw(wit1);

        // Interest removed ❌

        System.out.println("\n----- Current Account -----");
        CurrentAccount ca = new CurrentAccount(2000);

        System.out.print("Enter deposit amount for Current: ");
        double dep2 = sc.nextDouble();
        ca.deposit(dep2);

        System.out.print("Enter withdrawal amount for Current: ");
        double wit2 = sc.nextDouble();
        ca.withdraw(wit2);

        sc.close();
    }
}


// ================= PARENT CLASS =================
class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        double before = balance;
        balance += amount;

        System.out.println("Before Deposit Balance: " + before);
        System.out.println("Deposited Amount: " + amount);
        System.out.println("After Deposit Balance: " + balance);
    }

    public void withdraw(double amount) {
        double before = balance;

        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Before Withdraw Balance: " + before);
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("After Withdraw Balance: " + balance);
        }
    }
}


// ================= SAVINGS ACCOUNT =================
class SavingsAccount extends BankAccount {

    public SavingsAccount(double balance) {
        super(balance);
    }
}


// ================= CURRENT ACCOUNT =================
class CurrentAccount extends BankAccount {

    private double overdraftLimit = 500;

    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        double before = getBalance();

        if (amount > before + overdraftLimit) {
            System.out.println("Overdraft limit exceeded!");
        } else {
            setBalance(before - amount);
            System.out.println("Before Withdraw Balance: " + before);
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("After Withdraw Balance: " + getBalance());
        }
    }
}
