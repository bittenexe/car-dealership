package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class DealershipFileManager {
    private ArrayList<Vehicle> carList;

    public DealershipFileManager() {
        this.carList = new ArrayList<>();
    }

    //
    public AutoCorrect getDealership() {
        AutoCorrect dealership =  null;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String line;

            if ((line = reader.readLine()) !=null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    dealership = new AutoCorrect(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3]);
                }
            }
            while ((line = reader.readLine()) != null && dealership !=null) {
                String[] vParts = line.split("\\|");
                if (vParts.length >= 8) {
                    Vehicle entry = new Vehicle(
                            Integer.parseInt(vParts[0]),
                            Integer.parseInt(vParts[1]),
                            vParts[2],
                            vParts[3],
                            vParts[4],
                            vParts[5],
                            Integer.parseInt(vParts[6]),
                            new BigDecimal(vParts[7])
                    );
                    dealership.addVehicle(entry);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
        }
        return dealership;
    }

    public static void saveDealership(AutoCorrect dealership) {
    }
}