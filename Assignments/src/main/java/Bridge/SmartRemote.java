package Bridge;

public class SmartRemote extends BasicRemote{
    protected boolean voiceControl;

    public SmartRemote(Device device) {
        super.device = device;
    }

    @Override
    public void power() {
        System.out.println("Smart Remote: power toggle with voice control " + (voiceControl ? "enabled" : "disabled"));
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }
    @Override
    public void channelUp() {
        System.out.println("Smart Remote: channel up with voice control " + (voiceControl ? "enabled" : "disabled"));
        device.setChannel(device.getChannel() + 1);
    }
    @Override
    public void channelDown() {
        System.out.println("Smart Remote: channel down with voice control " + (voiceControl ? "enabled" : "disabled"));
        device.setChannel(device.getChannel() - 1);
    }
    public void enableVoiceControl() {
        System.out.println("Voice control enabled.");
        voiceControl = true;
    }
    public void disableVoiceControl() {
        System.out.println("Voice control disabled.");
        voiceControl = false;
    }
    public void browseInternet() {
        device.browseInternet();
    }

}
