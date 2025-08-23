package Composite;

import java.util.ArrayList;

public class Department extends AbstractComponent{
    protected String name;
    protected ArrayList<AbstractComponent> componentList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.println("Department: " + name);
        for (AbstractComponent component : componentList) {
            component.Operation();
        }
    }

    @Override
    public void Add(AbstractComponent component) {
        componentList.add(component);
    }

    @Override
    public void Remove(AbstractComponent component) {
        componentList.remove(component);
    }

    @Override
    public Integer getSalary() {
        Integer total = 0;
        for (AbstractComponent component: componentList) {
            total += component.getSalary();
        }
        return total;
    }

    @Override
    public void constructXML() {
        System.out.println("<Department name=\"" + name + "\">");
        for (AbstractComponent component : componentList) {
            component.constructXML();
        }
        System.out.println("</Department>");
    }

    @Override
    public AbstractComponent GetChild(int index) {
        return null;
    }
}
