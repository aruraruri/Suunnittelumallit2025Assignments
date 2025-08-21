package AbstractFactoryMethod;

import AbstractFactoryMethod.ConcreteClassesB.CheckboxB;

public abstract class AbstractUIFactory {
    public abstract AbstractButton createButton(String text);
    public abstract AbstractCheckbox createCheckbox(String text);
    public abstract AbstractTextField createTextField(String text);
}
