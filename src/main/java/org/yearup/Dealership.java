package org.yearup;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // Add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Remove a vehicle from the inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    // Get all vehicles in the inventory
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Search for vehicles within a price range
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Search for vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Search for vehicles by year range
    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Search for vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if(vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Search for vehicles by mileage range
    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if(vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Search for vehicles by type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // ... continuation of the Dealership class ...

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for inventory
    public List<Vehicle> getInventory() {
        return inventory;
    }

    // Setter for inventory
    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }
}

