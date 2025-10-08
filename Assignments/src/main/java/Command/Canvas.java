package Command;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Canvas {
    private GridPane grid;
    private int cursorAtIndex;
    private final int rows = 8;
    private final int cols = 8;
    private boolean[][] pixelStates;

    public Canvas(Stage stage) {
        grid = new GridPane();
        cursorAtIndex = 0;

        pixelStates = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Rectangle rect = new Rectangle(50, 50);
                rect.setStyle("-fx-fill: white; -fx-stroke: black;");
                grid.add(rect, j, i);
            }
        }
        highlightCursor();

        stage.setTitle("8x8 Pixel Painter");
        stage.setScene(new Scene(grid, 400, 400));
        stage.show();

    }

    public GridPane getGrid() {
        return grid;
    }

    public void moveCursor(int addX, int addY) {
        unhighlightCursor();
        int row = cursorAtIndex / cols;
        int col = cursorAtIndex % cols;
        row = Math.max(0, Math.min(rows - 1, row + addY));
        col = Math.max(0, Math.min(cols - 1, col + addX));
        cursorAtIndex = row * cols + col;
        highlightCursor();
    }

    private void highlightCursor() {
        int row = cursorAtIndex / cols;
        int col = cursorAtIndex % cols;
        Rectangle rect = (Rectangle) getNodeByRowColumnIndex(row, col);
        if (rect != null) {
            rect.setFill(Color.YELLOW);
        }
    }

    private void unhighlightCursor() {
        int row = cursorAtIndex / cols;
        int col = cursorAtIndex % cols;
        Rectangle rect = (Rectangle) getNodeByRowColumnIndex(row, col);
        if (rect != null) {
            // Restore the actual pixel state, not just white
            Color fillColor = pixelStates[row][col] ? Color.BLACK : Color.WHITE;
            rect.setFill(fillColor);
        }
    }

    private Node getNodeByRowColumnIndex(final int row, final int column) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return node;
            }
        }
        return null;
    }

    public void toggleCurrentPixel() {
        int row = cursorAtIndex / cols;
        int col = cursorAtIndex % cols;
        Rectangle rect = (Rectangle) getNodeByRowColumnIndex(row, col);
        if (rect != null) {
            pixelStates[row][col] = !pixelStates[row][col]; // Toggle the state
            rect.setFill(pixelStates[row][col] ? Color.BLACK : Color.WHITE);
        }
    }

    public void printPixels() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(pixelStates[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
