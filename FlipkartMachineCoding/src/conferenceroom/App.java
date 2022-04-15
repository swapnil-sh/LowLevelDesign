package conferenceroom;

import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* ADD CONFROOM c1 1 cb1 */

        String s = br.readLine();
        String[] ip = s.split("\\s+");
        BookRoomService brs = null;

        while (true) {
            brs = new BookRoomService();
            switch (ip[0]) {

            case "ADD":

                switch (ip[1]) {

                case "BUILDING":
                    String buildName = ip[2];
                    // build[i++]= new Building(name);
                    // BookRoomService.addBuilding(build, i);
                    brs.addBuilding(buildName);
                    break;

                case "Floor":
                    String bname = ip[2];
                    String fname = ip[3];
                    brs.addFloor(bname, fname);
                    break;

                case "CONFROOM":
                    String buildingName = ip[2];
                    String floorName = ip[3];
                    String roomId = ip[4];
                    brs.addConfRoom(buildingName, floorName, roomId);
                    break;

                default:
                    System.out.println("Try Again!");
                    break;
                }
                break;

            case "BOOK":
                int startTime = Integer.parseInt(ip[1]);
                int endTime = Integer.parseInt(ip[2]);
                String buildingName = ip[2];
                String floorName = ip[3];
                String roomId = ip[4];
                brs.bookSlot(startTime, endTime, buildingName, floorName, roomId);
                break;

            case "CANCEL":
                int stTime = Integer.parseInt(ip[1]);
                int eTime = Integer.parseInt(ip[2]);
                String builName = ip[2];
                String floName = ip[3];
                String roId = ip[4];
                brs.cancelSlot(stTime, eTime, builName, floName, roId);
                break;

            case "LIST":
                brs.listBooking();
                break;

            case "EXIT":
                System.out.println("Try Again!");
                break;

            default:
                System.out.println("Try Again!");
                break;

            }

            s = br.readLine();
            ip = s.split("\\s+");
        }
    }
}
