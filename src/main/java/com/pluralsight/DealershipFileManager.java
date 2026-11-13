package com.pluralsight;

import java.util.*;

public class DealershipFileManager {
        private ArrayList<Vehicle> carList;

        public DealershipFileManager() {
            this.carList = new ArrayList<>();
        }

        public ArrayList<Vehicle> getDealership() {
            ArrayList<Vehicle> vehicles = new ArrayList<>(carList);
            return vehicles;
        }

        public static void saveDealership(AutoCorrect dealership) {
        }
}


