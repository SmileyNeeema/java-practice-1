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
    void returnCar(Car c) { cars.remove(c); }

    boolean hasCar(Car c) { return cars.contains(c); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        // Sample cars
        cars.add(new Car("C1", "Toyota", 50));
        cars.add(new Car("C2", "Honda", 40));

        // Sample customer
        customers.add(new Customer("U1", "Joy"));

        while (true) {
            System.out.println("\n1. Show Cars  2. Rent Car  3. Return Car  4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                for (Car c : cars) System.out.println(c);

            } else if (choice == 2) {
                System.out.print("Car ID: "); 
                String cid = sc.nextLine();
                System.out.print("Customer ID: "); 
                String uid = sc.nextLine();

                Car carToRent = null;
                Customer cust = null;

                for (Car c : cars) if (c.id.equals(cid) && c.available) carToRent = c;
                for (Customer c : customers) if (c.id.equals(uid)) cust = c;

                if (carToRent != null && cust != null) {
                    carToRent.rent();
                    cust.rentCar(carToRent);
                    System.out.println("Rented!");
                } else {
                    System.out.println("Cannot rent. Either car is unavailable or customer not found.");
                }

            } else if (choice == 3) {
                System.out.print("Car ID: "); 
                String cid = sc.nextLine();
                System.out.print("Customer ID: "); 
                String uid = sc.nextLine();

                Car carToReturn = null;
                Customer cust = null;

                for (Car c : cars) if (c.id.equals(cid)) carToReturn = c;
                for (Customer c : customers) if (c.id.equals(uid)) cust = c;

                if (carToReturn != null && cust != null) {
                    if (cust.hasCar(carToReturn)) {
                        carToReturn.back();
                        cust.returnCar(carToReturn);
                        System.out.println("Returned!");
                    } else {
                        System.out.println("This customer did not rent this car.");
                    }
                } else {
                    System.out.println("Cannot return. Car or customer not found.");
                }

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
