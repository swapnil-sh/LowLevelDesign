package conferenceroom;

import model.*;
import java.io.*;
import java.util.*;

class Pair {

    String s1;
    String s2;

    public Pair(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
}

public class BookRoomService {

    ArrayList<String> build;
    HashMap<String, ArrayList<String>> floors;
    HashMap<Pair, ArrayList<String>> conferenceRooms;
    HashMap<String, Integer> booked;
    HashMap<String, String> bookedSLots;
    int st, end;

    public void printBuilding() {
        for (int i = 0; i < build.size(); i++)
            System.out.print(build.get(i) + " ");

        System.out.println();
    }

    public void printFloor(String buildingName) {

        for (Map.Entry<String, ArrayList<String>> i : floors.entrySet()) {
            System.out.print(i.getKey() + " " + i.getValue());
        }

        System.out.println();
    }

    public boolean buildExists(String buildingName) {
        for (int i = 0; i < build.size(); i++) {

            if (buildingName == build.get(i))
                return true;
        }
        return false;
    }

    public boolean floorExists(String buildingName, String floorName) {
        ArrayList<String> f = floors.get(buildingName);
        for (int i = 0; i < f.size(); i++) {

            if (floorName == f.get(i))
                return true;
        }
        return false;
    }

    public boolean confRoomExists(String buildingName, String floorName, String roomid, Pair p) {

        ArrayList<String> rooms = conferenceRooms.get(p);

        for (int i = 0; i < rooms.size(); i++) {

            if (roomid == rooms.get(i))
                return true;
        }
        return false;
    }

    public void addBuilding(String buildingName) {

        if (!buildExists(buildingName))
            build.add(buildingName);
        else {
            System.out.println("Already Exists");
            return;
        }
    }

    public void addFloor(String buildingName, String floorName) {

        if (!buildExists(buildingName)) {
            System.out.println("Building Doesnt Exists");
            return;
        }
        if (floorExists(buildingName, floorName)) {
            System.out.println("Already Exists");
            return;
        }

        floors.get(buildingName).add(floorName);
        System.out.println("Floor Added in building" + buildingName);
    }

    public void addConfRoom(String buildingName, String floorName, String roomId) {

        Pair p = new Pair(buildingName, floorName);
        if (!buildExists(buildingName)) {
            System.out.println("Build Doesnt Exists");
            return;
        }

        if (!floorExists(buildingName, floorName)) {
            System.out.println("Floor Doesnt Exists");
            return;
        }

        if (confRoomExists(buildingName, floorName, roomId, p)) {
            System.out.println("Room Already Exists");
        }

        if (conferenceRooms.get(p) != null)
            conferenceRooms.put(p, new ArrayList<>().add(roomId));
        else
            conferenceRooms.put(conferenceRooms.get(p), new ArrayList<>().add(roomId));

    }

    public void listBooking() {

    }

    boolean checkValidTime(int time) {
        if (time < 0 || time > 23)
            return false;
        return true;
    }

    public void bookSlot(int startTime, int endTime, String buildingName, String floorName, String roomId) {

        if (!checkValidTime(startTime) || !checkValidTime(endTime)) {
            System.out.println("Invalid Time");
            return;
        }

        Pair p = new Pair(buildingName, floorName);
        if (!buildExists(buildingName)) {
            System.out.println("Build Doesnt Exists");
            return;
        }

        if (!floorExists(buildingName, floorName)) {
            System.out.println("Floor Doesnt Exists");
            return;
        }

        if (!confRoomExists(buildingName, floorName, roomId, p)) {
            System.out.println("Room Doesnt Exists");
        }

        String unqId = buildingName + floorName + roomId;

        if (!bookedSLots.containsKey(unqId)) {
            bookedSLots.put(unqId, "Booked");
        }

        System.out.println("Room Booked!!!");
    }

    public void cancelSlot(int startTime, int endTime, String buildingName, String flooName, String roomId) {

    }

}
