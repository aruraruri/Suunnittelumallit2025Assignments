package Composite;

public class Employee extends AbstractComponent{
    protected String name;
    protected Integer salary;

    public Employee(String name) {
        this.name = name;
    }
    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void Operation() {
        System.out.println("Employee: " + name + " is performing an operation.");
    }

    @Override
    public void Add(AbstractComponent component) {

    }

    @Override
    public void Remove(AbstractComponent component) {

    }

    @Override
    public Integer getSalary() {
        return salary != null ? salary : 0;
    }

    @Override
    public void constructXML() {
        System.out.println("<Employee>");
        System.out.println("  <Name>" + name + "</Name>");
        if (salary != null) {
            System.out.println("  <Salary>" + salary + "</Salary>");
        }
        System.out.println("</Employee>");
    }

    @Override
    public AbstractComponent GetChild(int index) {
        return null;
    }
}
