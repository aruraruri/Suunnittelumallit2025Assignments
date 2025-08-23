package Composite;

public abstract class AbstractComponent {
    public abstract void Operation();
    public abstract void Add(AbstractComponent component);
    public abstract void Remove(AbstractComponent component);
    public abstract Integer getSalary();
    public abstract void constructXML();
    public abstract AbstractComponent GetChild(int index);
}
