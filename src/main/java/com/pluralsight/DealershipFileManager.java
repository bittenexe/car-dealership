package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class DealershipFileManager {

    public DealershipFileManager() {
    }

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String line;

            if ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    dealership = new Dealership(
                            parts[0],
                            parts[1],
                            parts[2]);
                }
            }

            while ((line = reader.readLine()) != null && dealership != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] vParts = line.split("\\|");
                if (vParts.length >= 8) {
                    try {
                        int vin = Integer.parseInt(vParts[0].trim());

                        Vehicle entry = new Vehicle(
                                vin,
                                Integer.parseInt(vParts[1].trim()),
                                vParts[2].trim(),
                                vParts[3].trim(),
                                vParts[4].trim(),
                                vParts[5].trim(),
                                Integer.parseInt(vParts[6].trim()),
                                new BigDecimal(vParts[7].trim())
                        );
                        dealership.addVehicle(entry);
                    } catch (NumberFormatException e) {
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Ducking hell, something went wrong.");
            e.printStackTrace();
        }

        return dealership;
    }

    public static void saveDealership(Dealership dealership) {
    }
}