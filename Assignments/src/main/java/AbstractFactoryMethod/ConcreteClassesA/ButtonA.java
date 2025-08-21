package AbstractFactoryMethod.ConcreteClassesA;

import AbstractFactoryMethod.AbstractButton;

public class ButtonA extends AbstractButton {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("Displaying Button A");
    }
}
