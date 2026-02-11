package oopsdemo;
class Employee {
    private int salary = 40000;

    public int getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    void displaySalary() {
        System.out.println("Salary is: " + getSalary());
    }
}

public class Company {   // Main class can be any name
    public static void main(String[] args) {
        Manager m = new Manager();
        m.displaySalary();
    }
}
