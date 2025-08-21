package AbstractFactoryMethod;

public abstract class AbstractTextField {
    protected String text;

    public AbstractTextField(String text) {
        this.text = text;
    }

    public abstract void display();
    public void setText(String text) {
        this.text = text;
    }
}
