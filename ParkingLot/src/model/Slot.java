package model;

class Slot {

    private int slotNumber;
    private int floorNumber;
    private String slotType;
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    private boolean isBooked;

    Slot(int floorNumber, int slotNumber, String slotType) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        isBooked = false;
    }

    public boolean getBooked() {
        return isBooked;
    }

    public String generateTicketID() {
        return "_" + (floorNumber + 1) + "_" + (slotNumber + 1);
    }

    public Vehicle freeSlot() {
        isBooked = false;
        Vehicle freedVehicle = vehicle;
        setVehicle(null);
        return freedVehicle;
    }
}