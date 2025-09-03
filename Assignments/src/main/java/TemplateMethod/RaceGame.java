package TemplateMethod;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RaceGame extends Game{
    private ArrayList<Player> players = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int turnCount = 0;

    @Override
    public void initializeGame(int numberOfPlayers) {
        for (int i=0; i<numberOfPlayers; i++) {
            players.add(new Player("Player " + (i+1)));
        }
        System.out.println("Game initialized with " + numberOfPlayers + " players.");
        System.out.println("Press 'd' and 'enter' to move right. Each turn lasts 5 seconds.");
        System.out.println("Furthest player to the right in 8 turns wins!");
        System.out.println("Enter to start...");
        scanner.nextLine();
    }

    @Override
    public boolean endOfGame() {
        if (turnCount>=8) {
            return true;
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        boolean startTurn = true;
        long currentTime = 0;
        if (startTurn) {
            currentTime = System.nanoTime()/1000000000;
            startTurn = false;
        }

        while ((System.nanoTime()/1000000000) - currentTime < 5) {
            // turn display
            System.out.print((players.get(player).getName() + " is playing...\r"));
            System.out.println();

            for (Player p: players) {
                System.out.print(p.getPosition()+"\r");
                System.out.println();
            }

            if (Objects.equals(scanner.nextLine(), "d")) {
                players.get(player).moveRight();
            }

            // let's not lag my poor pc too much
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        turnCount++;
        endOfGame();
    }

    @Override
    public void displayWinner() {
        Player winner = players.getFirst();
        for (Player p: players) {
            if (p.getPosition().length() > winner.getPosition().length()) {
                winner = p;
            }
        }
        System.out.println("The winner is " + winner.getName()+ "!");
    }
}
