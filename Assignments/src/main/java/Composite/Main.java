package Composite;

public class Main {
    public static void main(String[] args) {
        Department salesCompany = new Department("Sales Company");
        Department salesDept = new Department("Sales");
        Department marketingDept = new Department("Marketing");

        salesDept.Add(marketingDept);
        salesCompany.Add(salesDept);

        Department hrDept = new Department("HR");
        Department itDept = new Department("IT");

        salesCompany.Add(hrDept);
        salesCompany.Add(itDept);

        Employee emp1 = new Employee("Pertti", 2200);
        Employee emp2 = new Employee("Liisa", 3500);
        Employee emp3 = new Employee("Milla", 1900);

        salesDept.Add(emp1);
        marketingDept.Add(emp2);
        itDept.Add(emp3);

        salesCompany.Operation();

        System.out.println("Total salary of Sales Company: " + salesCompany.getSalary());

        salesCompany.constructXML();
    }
}
