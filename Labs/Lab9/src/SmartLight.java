public class SmartLight implements SmartDevice {
  private boolean isOn;

  public SmartLight() {
    this.isOn = false;
  }

  @Override
  public void turnOn() {
    isOn = true;
    System.out.println("Smart light turned on.");
  }

  @Override
  public void turnOff() {
    isOn = false;
    System.out.println("Smart light turned off.");
  }

  @Override
  public String getStatus() {
    return isOn ? "SmartLight is ON" : "SmartLight is OFF";
  }
}
