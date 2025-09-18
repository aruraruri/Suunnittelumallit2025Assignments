package Builder;

public class ComputerDirector {
    private ComputerBuilder builder;
    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructBeefyComputer() {
        builder.buildMotherboard();
        builder.buildRAM();
        builder.buildRAM();
        builder.buildProcessor();
        builder.buildGraphicsCard();
        builder.buildGraphicsCard();
        builder.buildHardDrive();
        builder.buildOperatingSystem();
    }

    public void constructBasicComputer() {
        builder.buildMotherboard();
        builder.buildRAM();
        builder.buildProcessor();
        builder.buildGraphicsCard();
        builder.buildHardDrive();
        builder.buildOperatingSystem();
    }
}
