package Flyweight.View;

import Flyweight.Model.Game;
import Flyweight.Model.Tiles.Tile;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.util.List;

public class GameController {
    private Game game;

    @FXML
    private GridPane tileGrid;

    public void startGame() {
        game = new Game();
        List<Tile> tiles = game.getMap().getTiles();
        tileGrid.getColumnCount();
        tileGrid.getRowCount();
    }
}
