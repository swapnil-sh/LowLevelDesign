package vehiclerental;

import vehicle.*;

import java.util.HashMap;

public class BookingCenter {
    private HashMap<String, Branch> branches;
    private String bookingCenterName;

    BookingCenter(String bookingCenterName) {
        branches = new HashMap<>();
        this.bookingCenterName = bookingCenterName;
    }

    public boolean addBranch(String branchName) {
        if (branches.get(branchName) != null) {
            System.out.println("Branch Name already exists");
            return false;
        }
        branches.put(branchName, new Branch(branchName));
        System.out.println("Branch added.");
        return true;
    }

    public boolean addVehicle(Vehicle vehicle) {
        String branchName = vehicle.getBranchName();
        return branches.get(branchName).addVehicle(vehicle);
    }

    public void displayBranch(String branchName, int timeSlot) {
        if (branches.get(branchName) == null) {
            System.out.println("Branch Doesn't exist");
            return;
        }
        System.out.println("Displaying branch data for each branch below");
        for (String currBranchName : branches.keySet()) {
            branches.get(currBranchName).displayBranch(timeSlot);
        }
        return;
    }

    public Vehicle bookSlot(String vehicleType, int timeSlot) {
        Vehicle vehicle = null;
        for (String branchName : branches.keySet()) {
            Branch branch = branches.get(branchName);
            Vehicle vehicle1 = branch.getBestVehicle(vehicleType, timeSlot);
            if (vehicle == null || vehicle.getRate() > vehicle1.getRate()) {
                vehicle = vehicle1;
            }
        }
        if (vehicle == null) {
            System.out.println("No vehicle found");
            return vehicle;
        }
        vehicle.setIthSlot(timeSlot);
        return vehicle;
    }

}