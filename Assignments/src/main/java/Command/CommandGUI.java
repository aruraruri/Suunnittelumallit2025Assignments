package Command;

import javafx.application.Application;
import javafx.stage.Stage;

public class CommandGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Canvas canvas = new Canvas(stage);

        // commands
        Command cursorUp = new CursorMoveUp(canvas);
        Command cursorDown = new CursorMoveDown(canvas);
        Command cursorLeft = new CursorMoveLeft(canvas);
        Command cursorRight = new CursorMoveRight(canvas);
        Command togglePixel = new TogglePixel(canvas);
        Command generateCode = new GenerateCode(canvas);

        // set key events
        stage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W -> cursorUp.execute();
                case S -> cursorDown.execute();
                case A -> cursorLeft.execute();
                case D -> cursorRight.execute();
                case SPACE -> togglePixel.execute();
                case C -> generateCode.execute();
            }
        });

        stage.setTitle("Command Pattern - Pixel Editor");
        stage.show();
    }
}
