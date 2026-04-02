public class SmartSpeaker implements SmartDevice {
  private boolean isOn;

  public SmartSpeaker() {
    this.isOn = false;
  }

  @Override
  public void turnOn() {
    isOn = true;
    System.out.println("Smart speaker turned on.");
  }

  @Override
  public void turnOff() {
    isOn = false;
    System.out.println("Smart speaker turned off.");
  }

  @Override
  public String getStatus() {
    return isOn ? "SmartSpeaker is ON" : "SmartSpeaker is OFF";
  }
}
