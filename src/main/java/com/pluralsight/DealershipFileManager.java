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
            String line = reader.readLine();
            boolean isFirstLine = false;

            String[] parts = line.split("\\|");
            if (parts.length >= 3) {
                dealership = new AutoCorrect(parts[0], parts[1], parts[2], parts[3]);
            }

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = true;
                    continue;
                }

                String[] dealershipParts = line.split("\\|");
                if (dealershipParts.length >= 8) {
                    Vehicle entry = new Vehicle(
                            Integer.parseInt(dealershipParts[0]),
                            Integer.parseInt(dealershipParts[1]),
                            dealershipParts[2],
                            dealershipParts[3],
                            dealershipParts[4],
                            dealershipParts[5],
                            Integer.parseInt(dealershipParts[6]),
                            new BigDecimal(dealershipParts[7])
                    );
                    carList.add(entry);
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