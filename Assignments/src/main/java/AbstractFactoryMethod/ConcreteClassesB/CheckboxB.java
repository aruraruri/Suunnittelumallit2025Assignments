package AbstractFactoryMethod.ConcreteClassesB;

import AbstractFactoryMethod.AbstractCheckbox;

public class CheckboxB extends AbstractCheckbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(5, text.length() + 1);
        String border = "+" + "-".repeat(width - 2) + "+";
        System.out.println(border);
        System.out.println("| " + String.format("%-" + (width - 4) + "s", text) + " |");
        System.out.println(border);
    }
}
