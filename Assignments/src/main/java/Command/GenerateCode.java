package Command;

public class GenerateCode  implements Command{
    private final Canvas canvas;
    public GenerateCode(Canvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void execute() {
        canvas.printPixels();
    }
}
