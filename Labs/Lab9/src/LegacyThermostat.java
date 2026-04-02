public class LegacyThermostat {
  private boolean active;
  private int currentTemp;

  public LegacyThermostat() {
    this.active = false;
    this.currentTemp = 22;
  }

  public void activate() {
    active = true;
    System.out.println("Legacy thermostat activated.");
  }

  public void deactivate() {
    active = false;
    System.out.println("Legacy thermostat deactivated.");
  }

  public int getCurrentTemp() {
    return currentTemp;
  }

  public boolean isActive() {
    return active;
  }
}
