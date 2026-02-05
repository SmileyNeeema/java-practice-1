import java.util.ArrayList;
import java.util.Scanner;

class Car {
    String id, model;
    double price;
    boolean available = true;

    Car(String id, String model, double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    void rent() { available = false; }
    void back() { available = true; }

    public String toString() {
        return id + " | " + model + " | $" + price + " | " + (available ? "Available" : "Rented");
    }
}

class Customer {
    String id, name;
    ArrayList<Car> cars = new ArrayList<>();

    Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void rentCar(Car c) { cars.add(c); }
    void re
