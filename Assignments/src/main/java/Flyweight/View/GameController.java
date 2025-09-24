package Flyweight.View;

import Flyweight.Model.Game;
import Flyweight.Model.Tiles.Tile;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;

public class GameController {
    private Game game;

    @FXML
    private GridPane tileGrid;

    public void startGame() {
        game = new Game();
        List<Tile> tiles = game.getMap().getTiles();
        int col = 0;
        int row = 0;
        for (int i=0;i<tiles.size();i++) {
            ImageView imageView = new ImageView(tiles.get(i).getImg());
            tileGrid.add(imageView, col, row);
            col++;
            if (col>=5) {
                col = 0;
                row++;
            }
        }

    }
}
