package oopsdemo;

class Car {
    String color = "Red";

    void showColor() {
        System.out.println("RED");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();   
        myCar.showColor();       
    }
}

