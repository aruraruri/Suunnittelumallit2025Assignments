package Builder;

public class OfficePcBuilder implements ComputerBuilder{
    private Computer computer;

    public OfficePcBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildMotherboard() {
        computer.addComponent(new Component("A non-descript motherboard from 2007"));
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel Pentium 4"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("Some RAM", 4000.0));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("Disk drive", 20000.0));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("No GPU"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 8"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
