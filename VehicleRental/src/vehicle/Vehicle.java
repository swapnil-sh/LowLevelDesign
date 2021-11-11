package vehicle;

public abstract class Vehicle {

    private String vehicleType;
    private String registrationNumber, branchName;
    private int rate;

    public void setSlots(int[] slots) {
        this.slots = slots;
    }

    private int[] slots = new int[24];

    public String getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getRate() {
        return rate;
    }

    public int[] getSlots() {
        return slots;
    }

    public int isFree(int timeSlot) {
        return slots[timeSlot];
    }

    Vehicle(String[] args) {
        setBranchName(args[1]);
        setVehicleType(args[2]);
        setRegistrationNumber(args[3]);
        setRate(Integer.parseInt(args[4]));

    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setIthSlot(int timeSlot) {
        slots[timeSlot] = 1;
    }
}