package org.yearup;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private DealershipFileManager dfm;

    public UserInterface() {
        dfm = new DealershipFileManager();
        init();
    }

    private void init() {
        this.dealership = dfm.getDealership();    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Add a vehicle");
            System.out.println("3 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    processGetAllVehiclesRequest();
                    break;
                case "2":
                    processAddVehicleRequest(scanner);
                    break;
                case "3":
                    processRemoveVehicleRequest(scanner);
                    break;
                case "99":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!input.equals("99"));
        scanner.close();
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processAddVehicleRequest(Scanner scanner) {
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.print("Enter vehicle mileage: ");
        double mileage = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter vehicle price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(make, model, year, color, mileage, price, type);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicleRequest(Scanner scanner) {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
