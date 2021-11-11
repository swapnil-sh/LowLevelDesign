package parkinglot;

import java.util.*;
import model.*;

public class ParkingLot {

    private String parkingLotName;
    Vector<Floor> floors;

    ParkingLot(String parkingLotName, int floorCount, int slotCountInEachFloor) {
        this.parkingLotName = parkingLotName;
        floors = new Vector<Floor>(floorCount);
        for (int i = 0; i < floorCount; i++) {
            floors.add(i, new Floor(slotCountInEachFloor, i, parkingLotName));
        }
        System.out.println(
                "Created parking lot with " + floorCount + " floors and " + slotCountInEachFloor + " slots per floor");
    }

    public void displayFreeCount(String vehicleType) {
        for (int i = 0; i < floors.size(); i++) {
            int freeCount = floors.get(i).getFreeCount(vehicleType);
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i + 1) + ": " + freeCount);
        }
    }

    public void displayFreeSlots(String vehicleType) {
        for (int i = 0; i < floors.size(); i++) {
            System.out.print("Free slots for " + vehicleType + " on Floor " + (i + 1) + ": ");
            floors.get(i).displayFreeSlots(vehicleType);
        }
    }

    public void displayOccupiedSlots(String vehicleType) {
        for (int i = 0; i < floors.size(); i++) {
            System.out.print("Occupied slots for " + vehicleType + " on Floor " + (i + 1) + ": ");
            floors.get(i).displayOccupiedSlots(vehicleType);
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < floors.size(); i++) {
            if (floors.get(i).parkVehicle(vehicle)) {
                return;
            }
        }
        System.out.println("Parking Lot Full");
        return;

    }

    public void unparkVehicle(String ticket) {
        String[] input = ticket.trim().split("_");
        int floorNumber = Integer.parseInt(input[1]) - 1;
        int slotNumber = Integer.parseInt(input[2]) - 1;
        if (input[0].equals(parkingLotName) && floorNumber < floors.size()
                && slotNumber < floors.get(0).getSlots().size()) {
            if (floors.get(floorNumber).unparkVehicle(slotNumber)) {
                return;
            }
        }
        System.out.println("Invalid Ticket");
        return;
    }
}