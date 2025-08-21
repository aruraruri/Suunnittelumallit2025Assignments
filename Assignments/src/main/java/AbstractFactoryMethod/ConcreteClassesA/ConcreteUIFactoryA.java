package AbstractFactoryMethod.ConcreteClassesA;

import AbstractFactoryMethod.AbstractButton;
import AbstractFactoryMethod.AbstractCheckbox;
import AbstractFactoryMethod.AbstractTextField;
import AbstractFactoryMethod.AbstractUIFactory;

public class ConcreteUIFactoryA extends AbstractUIFactory {
    @Override
    public AbstractButton createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public AbstractCheckbox createCheckbox(String text) {return new CheckboxA(text); }

    @Override
    public AbstractTextField createTextField(String text) {
        return new TextFieldA(text);
    }
}
