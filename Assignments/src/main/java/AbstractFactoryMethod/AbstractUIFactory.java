package AbstractFactoryMethod;

public abstract class AbstractUIFactory {
    public abstract AbstractButton createButton(String text);
    public abstract AbstractCheckbox createCheckbox(String text);
    public abstract AbstractTextField createTextField(String text);
}
