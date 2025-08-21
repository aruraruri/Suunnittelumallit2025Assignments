package AbstractFactoryMethod.ConcreteClassesB;

import AbstractFactoryMethod.AbstractButton;

public class ButtonB extends AbstractButton {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(5, text.length() + 4);
        String border = "+" + "-".repeat(width - 2) + "+";
        System.out.println(border);
        System.out.println("| " + String.format("%-" + (width - 4) + "s", text) + " |");
        System.out.println(border);
    }
}
