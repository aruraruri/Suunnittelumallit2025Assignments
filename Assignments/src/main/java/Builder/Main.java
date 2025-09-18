package Builder;

public class Main {
    public static void main(String[] args) {
        GamingPcBuilder gamingPcBuilder = new GamingPcBuilder();
        ComputerDirector director = new ComputerDirector(gamingPcBuilder);
        director.constructBeefyComputer();
        Computer gamingPc = gamingPcBuilder.getComputer();

        OfficePcBuilder officePcBuilder = new OfficePcBuilder();
        director = new ComputerDirector(officePcBuilder);
        director.constructBasicComputer();
        Computer officePc = officePcBuilder.getComputer();
        System.out.println("Gaming pc components:\n"+gamingPc);
        System.out.println("Office pc components:\n"+officePc);
    }
}
