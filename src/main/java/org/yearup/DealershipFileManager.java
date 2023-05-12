package org.yearup;

import java.io.*;
import java.util.List;

public class DealershipFileManager {
    private static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership() {
        Dealership dealership = new Dealership();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Assuming the CSV file format is as follows: make,model,year,color,mileage,price,type
                String make = parts[0];
                String model = parts[1];
                int year = Integer.parseInt(parts[2]);
                String color = parts[3];
                double mileage = Double.parseDouble(parts[4]);
                double price = Double.parseDouble(parts[5]);
                String type = parts[6];

                Vehicle vehicle = new Vehicle(make, model, year, color, mileage, price, type);
                dealership.addVehicle(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            List<Vehicle> vehicles = dealership.getAllVehicles();

            for (Vehicle vehicle : vehicles) {
                writer.write(String.format("%s,%s,%d,%s,%.2f,%.2f,%s\n",
                        vehicle.getMake(), vehicle.getModel(), vehicle.getYear(),
                        vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice(), vehicle.getType()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
