package Command;

public class CursorMoveDown implements Command{
    private final Canvas canvas;

    public CursorMoveDown(Canvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void execute() {
        canvas.moveCursor(0, 1);
    }
}
