package TemplateMethod;

import java.util.ArrayList;

public class RaceGame extends Game{
    private ArrayList<Player> players = new ArrayList<>();
    @Override
    public void initializeGame(int numberOfPlayers) {
        for (int i=0; i<numberOfPlayers; i++) {
            players.add(new Player("Player " + (i+1)));
        }
    }

    @Override
    public boolean endOfGame() {
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

            // let's not lag my poor pc too much
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void displayWinner() {

    }
}
