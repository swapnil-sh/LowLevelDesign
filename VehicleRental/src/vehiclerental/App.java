package vehiclerental;

import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(
                new FileReader("/home/gaurav/IdeaProjects/VehicleRental/src/input.txt"));
        PrintStream out = new PrintStream(
                new FileOutputStream("/home/gaurav/IdeaProjects/VehicleRental/src/output.txt"));
        System.setOut(out);
        String[] input;
        input = reader.readLine().trim().split("\\s+");
        VehicleFactory vehicleFactory = new VehicleFactory();
        BookingCenter bookingCenter = new BookingCenter("HQ");
        while (input[0].equals("exit") == false) {
            switch (input[0]) {
            case "addBranch":
                bookingCenter.addBranch(input[1]);
                break;
            case "addVehicle":
                Vehicle vehicle = vehicleFactory.createVehicle(input);
                if (vehicle != null) {
                    System.out.println("Added vehicle ");
                    bookingCenter.addVehicle(vehicle);
                }
                break;
            case "bookSlot":
                vehicle = bookingCenter.bookSlot(input[1], Integer.parseInt(input[2]));
                if (vehicle != null) {
                    System.out.println("Booked " + vehicle.getVehicleType() + " with registration number "
                            + vehicle.getRegistrationNumber() + " for rate of " + vehicle.getRate());
                }
                break;
            case "displayBranch":
                bookingCenter.displayBranch(input[1], Integer.parseInt(input[2]));
                break;
            default:
                System.out.println("Wrong input. Enter again");
                break;
            }
            input = reader.readLine().trim().split("\\s+");
        }
    }
}
