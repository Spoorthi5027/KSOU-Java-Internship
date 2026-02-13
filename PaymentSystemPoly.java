package payments;

import java.util.Scanner;


class Payment {
 public void pay(double amount) {
     System.out.println("Processing payment...");
 }
}


class UPI extends Payment {
 @Override
 public void pay(double amount) {
     System.out.println("Processing UPI payment...");
     System.out.println("₹" + amount + " was debited from your UPI account");
 }
}


class DebitCard extends Payment {
 @Override
 public void pay(double amount) {
     System.out.println("Processing Debit Card payment...");
     System.out.println("₹" + amount + " was debited from your Debit Card");
 }
}


class CreditCard extends Payment {
 @Override
 public void pay(double amount) {
     System.out.println("Processing Credit Card payment...");
     System.out.println("₹" + amount + " was debited from your Credit Card");
 }
}


class Cash extends Payment {

 public void pay(double amount) {
     System.out.println("Cash received: ₹" + amount);
     System.out.println("Thanks for shopping!");
 }
}


public class PaymentSystemPoly {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.print("Enter amount to pay: ");
     double amount = sc.nextDouble();

     System.out.println("\nSelect Payment Method:");
     System.out.println("1. UPI");
     System.out.println("2. Debit Card");
     System.out.println("3. Credit Card");
     System.out.println("4. Cash");

     System.out.print("Enter your choice: ");
     int choice = sc.nextInt();

     Payment payment; 
     switch (choice) {
         case 1:
             payment = new UPI();
             break;
         case 2:
             payment = new DebitCard();
             break;
         case 3:
             payment = new CreditCard();
             break;
         case 4:
             payment = new Cash();
             break;
         default:
             System.out.println("Invalid option");
             return;
     }

     payment.pay(amount); 
 }
}
