package Command;

public class CursorMoveLeft implements Command{
    private final Canvas canvas;

    public CursorMoveLeft(Canvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void execute() {
        canvas.moveCursor(-1, 0);
    }
}
