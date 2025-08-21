package AbstractFactoryMethod;

public abstract class AbstractButton {
    protected String text;

    public AbstractButton(String text) {
        this.text = text;
    }

    public abstract void display();

    public void setText(String text) {
        this.text = text;
    }
}