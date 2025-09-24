package Flyweight.View;

import Flyweight.Model.Game;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class GameController {
    private Game game;

    @FXML
    private GridPane tileGrid;

    public void startGame() {
        game = new Game();
        game.getMap().display();
    }
}
