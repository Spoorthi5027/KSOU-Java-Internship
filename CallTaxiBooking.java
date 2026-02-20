package cab;

import java.util.*;


class Booking {
    int bookingId;
    int customerId;
    char from;
    char to;
    int pickupTime;
    int dropTime;
    int amount;

    Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }
}

class Taxi {
    int taxiId;
    char currentLocation = 'A';
    int freeTime = 0;
    int totalEarnings = 0;
    List<Booking> bookings = new ArrayList<>();

    Taxi(int id) {
        this.taxiId = id;
    }
}

class NoTaxiAvailableException extends Exception {
    NoTaxiAvailableException(String msg) {
        super(msg);
    }
}

public class CallTaxiBooking {

    static List<Taxi> taxis = new ArrayList<>();
    static int bookingCounter = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Create taxis (can change number)
        for (int i = 1; i <= 4; i++) {
            taxis.add(new Taxi(i));
        }

        while (true) {
            System.out.println("\n--- Call Taxi Booking System ---");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        bookTaxiInput();
                    } catch (NoTaxiAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    displayTaxiDetails();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Input method
    static void bookTaxiInput() throws NoTaxiAvailableException {

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Pickup Point (A-F): ");
        char from = sc.next().toUpperCase().charAt(0);

        System.out.print("Enter Drop Point (A-F): ");
        char to = sc.next().toUpperCase().charAt(0);

        System.out.print("Enter Pickup Time (in hours): ");
        int pickupTime = sc.nextInt();

        bookTaxi(customerId, from, to, pickupTime);
    }

    // Core booking logic
    static void bookTaxi(int customerId, char from, char to, int pickupTime)
            throws NoTaxiAvailableException {

        Taxi allocatedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {

            if (taxi.freeTime <= pickupTime) {

                int distance = Math.abs(taxi.currentLocation - from);

                if (distance < minDistance) {
                    minDistance = distance;
                    allocatedTaxi = taxi;
                } else if (distance == minDistance && allocatedTaxi != null &&
                        taxi.totalEarnings < allocatedTaxi.totalEarnings) {
                    allocatedTaxi = taxi;
                }
            }
        }

        if (allocatedTaxi == null) {
            throw new NoTaxiAvailableException("❌ No taxi available at this time.");
        }

        int travelDistance = Math.abs(from - to) * 15;
        int travelTime = Math.abs(from - to) * 1;
        int amount = calculateFare(travelDistance);
        int dropTime = pickupTime + travelTime;

        Booking booking = new Booking(bookingCounter++, customerId, from, to, pickupTime, dropTime, amount);

        allocatedTaxi.bookings.add(booking);
        allocatedTaxi.totalEarnings += amount;
        allocatedTaxi.freeTime = dropTime;
        allocatedTaxi.currentLocation = to;

        System.out.println("✅ Taxi-" + allocatedTaxi.taxiId + " is allotted");
    }

    static int calculateFare(int distance) {
        if (distance <= 5)
            return 100;
        return 100 + (distance - 5) * 10;
    }

    static void displayTaxiDetails() {

        for (Taxi taxi : taxis) {

            if (taxi.bookings.isEmpty())
                continue;

            System.out.println("\nTaxi-" + taxi.taxiId + " Total Earnings: Rs. " + taxi.totalEarnings);
            System.out.println("BookingID  CustomerID  From  To  PickupTime  DropTime  Amount");

            for (Booking b : taxi.bookings) {
                System.out.println(
                        b.bookingId + "          " +
                                b.customerId + "          " +
                                b.from + "     " +
                                b.to + "     " +
                                b.pickupTime + "          " +
                                b.dropTime + "         " +
                                b.amount);
            }
        }
    }
}
