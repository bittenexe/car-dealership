package com.pluralsight;

import java.util.*;

public class AutoCorrect {

    private static Scanner scanner = new Scanner(System.in);
    private Dealership dealership;
    private DealershipFileManager dFiles = new DealershipFileManager();

    private void init() {
        this.dealership = dFiles.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = this.dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() { /* ... */ }
    private void processGetByYearRequest() { /* ... */ }
    private void processGetByColorRequest() { /* ... */ }
    private void processGetByMileageRequest() { /* ... */ }
    private void processGetByVehicleTypeRequest() { /* ... */ }
    private void processAddVehicleRequest() { /* ... */ }
    private void processRemoveVehicleRequest() { /* ... */ }

    public void display() {
        init();

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("\uD83C\uDFC1......AUTO CORRECT......\uD83C\uDFCE\uD83D\uDCA8..");
            System.out.println("Shift happens! We make sure it’s in the right gear.");
            System.out.println();
            System.out.println("\uD83C\uDFC1 1 \uD83C\uDFC1 Request a Price for a Vehicle");
            System.out.println("\uD83C\uDFC1 2 \uD83C\uDFC1 Search a Vehicle by Make & Model");
            System.out.println("\uD83C\uDFC1 3 \uD83C\uDFC1 Search a Vehicle by Year");
            System.out.println("\uD83C\uDFC1 4 \uD83C\uDFC1 Search a Vehicle by Color");
            System.out.println("\uD83C\uDFC1 5 \uD83C\uDFC1 Search a Vehicle by Mileage");
            System.out.println("\uD83C\uDFC1 6 \uD83C\uDFC1 Search a Vehicle by a Type (car, truck, etc)");
            System.out.println("\uD83C\uDFC1 7 \uD83C\uDFC1 All Vehicles");
            System.out.println("\uD83C\uDFC1 8 \uD83C\uDFC1 Add a Vehicle");
            System.out.println("\uD83C\uDFC1 9 \uD83C\uDFC1 Remove a Vehicle");
            System.out.println("\uD83C\uDFC1 99 \uD83C\uDFC1 Exit");

            System.out.print("Shift into command: "); //
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> System.out.println("Price request not implemented yet");
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> {
                    running = false;
                    System.out.println("Quatting while you're ahead? Gooddrive!");
                }
                default -> System.out.println("Invalid key! Did you drop yours in the ignishun?");
            }
        }
    }

    public static void main(String[] args) {
        AutoCorrect ui = new AutoCorrect();
        ui.display();
    }
}