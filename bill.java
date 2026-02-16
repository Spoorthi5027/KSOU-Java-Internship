package elcbill;

import java.util.Scanner;

/*public class bill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter units: ");
        int units = sc.nextInt();

        int bill = 0;

        if (units <= 100) {
            bill = units * 5;
        }

        if (units > 100 && units <= 200) {
            bill = (100 * 5) + (units - 100) * 7;
        }

        if (units > 200) {
            bill = (100 * 5) + (100 * 7) + (units - 200) * 10;
        }

        System.out.println("Bill amount = " + bill);
    }
}*/



public class bill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter units: ");
        int units = sc.nextInt();

        int bill = (units <= 100) 
                ? units * 5
                : (units <= 200) 
                    ? (100 * 5) + (units - 100) * 7
                    : (100 * 5) + (100 * 7) + (units - 200) * 10;

        System.out.println("Bill amount = " + bill);
    }
}

