package AbstractFactoryMethod;

public abstract class AbstractCheckbox {
    protected String text;

    public AbstractCheckbox(String text) {
        this.text = text;
    }
    public abstract void display();
    public void setText(String text) {
        this.text = text;
    }
}
