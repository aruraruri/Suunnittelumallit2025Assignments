package TemplateMethod;

public class Player {
    private String name;
    private String playerLocation = "o";

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPlayerLocation() {
        return playerLocation;
    }

    public void movePlayerRight() {
        playerLocation = " " + playerLocation;
    }
}
