package com.pluralsight;

import java.util.ArrayList;
public class AutoCorrect {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public AutoCorrect(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) { return null; }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) { return null; }
    public ArrayList<Vehicle> getVehiclesByYear(int year, int max) { return null; }
    public ArrayList<Vehicle> getVehiclesByColor (String color) { return null; }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) { return null; }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) { return null; }
    public ArrayList<Vehicle> getAllVehicles() { return null; }
    public void addVehicle(Vehicle vehicle) { inventory.add(vehicle); }
    public void removeVehicle(Vehicle vehicle) {inventory.remove(vehicle); }
    }

