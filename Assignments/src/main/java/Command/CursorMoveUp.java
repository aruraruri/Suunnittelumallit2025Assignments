package Command;

public class CursorMoveUp implements Command{
    private final Canvas canvas;

    public CursorMoveUp(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.moveCursor(0, -1);
    }
}
