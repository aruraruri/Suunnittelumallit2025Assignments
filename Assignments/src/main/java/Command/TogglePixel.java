package Command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TogglePixel implements Command{
    private final Canvas canvas;

    public TogglePixel(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.toggleCurrentPixel();
    }
}
