package Command;

public class CursorMoveRight implements Command{
    private final Canvas canvas;

    public CursorMoveRight(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.moveCursor(1, 0);
    }
}
