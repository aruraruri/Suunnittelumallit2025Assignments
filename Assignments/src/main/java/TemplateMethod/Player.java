package TemplateMethod;

public class Player {
    private String name;
    private String playerPosition = "o";

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return playerPosition;
    }

    public void moveRight() {
        playerPosition = " " + playerPosition;
    }
}
