package Builder;

public class GamingPcBuilder implements ComputerBuilder{
    private Computer computer;

    public GamingPcBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildMotherboard() {
        computer.addComponent(new Component("Asus B450"));
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Ryzen 7700"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("Corsair DDR5", 64000.0));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("SDD drive from a thrift store"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("PNY Geforce RTX 5080"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 11"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
