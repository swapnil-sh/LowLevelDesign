package vehicle;

public class VehicleFactory {
    public Vehicle createVehicle(String[] args) {
        Vehicle vehicle = null;
        switch (args[2]) {
        case "Car":
            vehicle = new Car(args);
            break;
        case "Bike":
            vehicle = new Bike(args);
            break;
        default:
            System.out.println("Wrong Vehicle. Vehicle type enter again");
            break;
        }
        return vehicle;
    }
}