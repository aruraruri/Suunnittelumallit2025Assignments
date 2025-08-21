package AbstractFactoryMethod.ConcreteClassesB;

import AbstractFactoryMethod.AbstractTextField;

public class TextFieldB extends AbstractTextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(4, text.length() + 4);
        String border = "+" + "-".repeat(width - 2) + "+";
        System.out.println(border);
        System.out.println("| " + String.format("%-" + (width - 4) + "s", text) + " |");
        System.out.println(border);
    }
}
