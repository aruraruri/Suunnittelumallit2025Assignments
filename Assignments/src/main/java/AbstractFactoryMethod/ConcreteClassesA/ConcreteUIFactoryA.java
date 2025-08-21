package AbstractFactoryMethod.ConcreteClassesA;

import AbstractFactoryMethod.AbstractButton;
import AbstractFactoryMethod.AbstractCheckbox;
import AbstractFactoryMethod.AbstractTextField;
import AbstractFactoryMethod.AbstractUIFactory;

public class ConcreteUIFactoryA extends AbstractUIFactory {
    @Override
    public AbstractButton createButton(String text) {
        return null;
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
