package AbstractFactoryMethod;

import AbstractFactoryMethod.ConcreteClassesA.ConcreteUIFactoryA;
import AbstractFactoryMethod.ConcreteClassesB.ConcreteUIFactoryB;

public class MainioMaini {
    public static void main(String[] args) {
        AbstractUIFactory factory = new ConcreteUIFactoryB();
        //AbstractUIFactory factory = new ConcreteUIFactoryA();

        AbstractButton button = factory.createButton("sKIBIDI");
        button.display();
    }
}
