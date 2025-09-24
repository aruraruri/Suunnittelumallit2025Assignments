package Bridge;

public class SmartTv extends Tv{

    public void browseInternet(){
        System.out.println("Browsing the internet on Smart TV");
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a smart TV set!");
        System.out.println("| I'm " + (super.isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + super.getVolume() + "%");
        System.out.println("| Current channel is " + super.getChannel());
        System.out.println("------------------------------------\n");
    }
}
