package model;

import java.util.*;

public class Floor {

    private Vector<Slot> slots;
    private int floorNumber;
    private String parkingLotName;

    public Vector<Slot> getSlots() {
        return slots;
    }

    public Floor(int slotCount, int floorNumber, String parkingLotName) {
        this.floorNumber = floorNumber;
        this.parkingLotName = parkingLotName;
        slots = new Vector<Slot>();
        for (int i = 0; i < Math.min(slotCount, 1); i++) {
            slots.add(i, new Slot(floorNumber, i, "TRUCK"));
        }
        for (int i = 1; i < Math.min(slotCount, 3); i++) {
            slots.add(i, new Slot(floorNumber, i, "BIKE"));
        }
        for (int i = 3; i < slotCount; i++) {
            slots.add(i, new Slot(floorNumber, i, "CAR"));
        }
    }

    public int getFreeCount(String vehicleType) {
        int freeCount = 0;
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).isBooked() == false && slots.get(i).getSlotType().equals(vehicleType)) {
                freeCount++;
            }
        }
        return freeCount;
    }

    public void displayFreeSlots(String vehicleType) {
        boolean printed = false;
        for (int i = 0; i < slots.size(); i++) {
            Slot currentSlot = slots.get(i);
            if (currentSlot.getSlotType().equals(vehicleType) && currentSlot.getBooked() == false) {
                if (printed) {
                    System.out.print(",");
                }
                printed = true;
                System.out.print(currentSlot.getSlotNumber() + 1);
            }
        }
        System.out.println();
    }

    public void displayOccupiedSlots(String vehicleType) {
        boolean printed = false;
        for (int i = 0; i < slots.size(); i++) {
            Slot currentSlot = slots.get(i);
            if (currentSlot.getSlotType().equals(vehicleType) && currentSlot.getBooked() == true) {
                if (printed) {
                    System.out.print(",");
                }
                printed = true;
                System.out.print(currentSlot.getSlotNumber() + 1);
            }
        }
        System.out.println();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).isBooked() == false && slots.get(i).getSlotType().equals(vehicle.getVehicleType())) {
                slots.get(i).setBooked(true);
                slots.get(i).setVehicle(vehicle);
                System.out.println("Parked Vehicle. Ticket ID: " + parkingLotName + slots.get(i).generateTicketID());
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(int slotNumber) {
        if (slots.get(slotNumber).getBooked()) {
            Vehicle vehicle = slots.get(slotNumber).freeSlot();
            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber()
                    + " and Color " + vehicle.getColor());
            return true;
        }
        return false;
    }
}
