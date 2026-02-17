package elcbill;

import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        int password = sc.nextInt();

        // Relational + Logical operator check
        if (username.equals("Admin") && password == 1234) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid username or password");
        }

        sc.close();
    }
}
