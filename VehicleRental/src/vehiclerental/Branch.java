package vehiclerental;

import vehicle.*;
import kotlin.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Branch {
    private HashMap<String, Vehicle> vehicles = null;
    private String branchName;

    Branch(String branchName) {
        vehicles = new HashMap<>();
        this.branchName = branchName;
    }

    public HashMap<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public boolean addVehicle(Vehicle vehicle) {
        String registrationNumber = vehicle.getRegistrationNumber();
        if (vehicles.get(registrationNumber) != null) {
            System.out.println("Vehicle already exists");
            return false;
        }
        vehicles.put(registrationNumber, vehicle);
        return true;
    }

    public void displayBranch(int timeSlot) {
        LinkedHashSet<Pair<Integer, String>> vehiclesByPrice = new LinkedHashSet<>();
        for (String registrationNumber : vehicles.keySet()) {
            Vehicle vehicle = vehicles.get(registrationNumber);
            if (vehicle.isFree(timeSlot) == 0) {
                vehiclesByPrice.add(new Pair(vehicle.getRate(), registrationNumber));
            }
        }
        for (Pair<Integer, String> currVehicle : vehiclesByPrice) {
            String registrationNumber = currVehicle.getSecond();
            System.out.println(
                    "VehicleType: " + vehicles.get(registrationNumber).getVehicleType() + " Registration Number "
                            + registrationNumber + " Rate: " + vehicles.get(registrationNumber).getRate());
        }
        return;
    }

    public Vehicle getBestVehicle(String vehicleType, int timeSlot) {
        Vehicle vehicle = null;
        for (String registrationNumber : vehicles.keySet()) {
            Vehicle vehicle1 = vehicles.get(registrationNumber);
            if (vehicle1.getVehicleType().equals(vehicleType) == false) {
                continue;
            }
            int[] slots = vehicle1.getSlots();
            if (slots[timeSlot] == 0 && (vehicle == null
                    || (vehicle1.getVehicleType().equals(vehicleType) && vehicle1.getRate() < vehicle.getRate()))) {
                vehicle = vehicle1;
            }
        }
        return vehicle;
    }

}