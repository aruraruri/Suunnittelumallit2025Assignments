package StateModel;

import java.util.Scanner;

public class GameCharacter {
    private final Scanner scanner = new Scanner(System.in);

    private State state;
    private String name = "Hero";
    private double xp = 0.0;
    private double hp = 100.0;
    private int level = 1;

    public GameCharacter() {
        state = new NoviceState(this);
    }

    public void play() {
        while (true) {
            if (state == null) {
                // should never happen
                System.out.println("Player out of order");
                return;
            }
            state.action();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addXp(double amount) {
        xp += amount;
        System.out.println("Experience: " + xp);
    }

    public double getXp() {
        return xp;
    }

    public void addHp(double amount) {
        hp += amount;
        System.out.println("Health: " + hp);
    }
    public double getHp() {
        return hp;
    }
    public int readUserChoice(String[] options) {
        // print options
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return scanner.nextInt();
    }

}

