package snl;

import java.util.*;
import model.Snake;
import model.Ladder;
import model.Player;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Taking input for Snakes
        System.out.println("Print the No of Snakes");
        int noOfSnakes = sc.nextInt();

        System.out.println("Enter the snakes and its positions");
        ArrayList<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Snake(sc.nextInt(), sc.nextInt()));
        }

        // Taking input for Snakes
        System.out.println("Print the No of Ladders");
        int noOfLadders = sc.nextInt();

        System.out.println("Enter the ladders and its positions");
        ArrayList<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(sc.nextInt(), sc.nextInt()));
        }

        // Taking input for PLayers
        System.out.println("Print the No of Players");
        int noOfPlayers = sc.nextInt();

        System.out.println("Enter the players");
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(sc.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);

        snakeAndLadderService.startGame();
    }
}
