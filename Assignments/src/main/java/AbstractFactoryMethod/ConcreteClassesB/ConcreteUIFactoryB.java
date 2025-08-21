package AbstractFactoryMethod.ConcreteClassesB;

import AbstractFactoryMethod.AbstractButton;
import AbstractFactoryMethod.AbstractCheckbox;
import AbstractFactoryMethod.AbstractTextField;
import AbstractFactoryMethod.AbstractUIFactory;

public class ConcreteUIFactoryB extends AbstractUIFactory {
    @Override
    public AbstractButton createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public AbstractCheckbox createCheckbox(String text) {
        return null;
    }

    @Override
    public AbstractTextField createTextField(String text) {
        return null;
    }
}
