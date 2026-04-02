public class LegacyThermostatAdapter implements SmartDevice {
  private LegacyThermostat legacyThermostat;

  public LegacyThermostatAdapter(LegacyThermostat legacyThermostat) {
    this.legacyThermostat = legacyThermostat;
  }

  @Override
  public void turnOn() {
    legacyThermostat.activate();
  }

  @Override
  public void turnOff() {
    legacyThermostat.deactivate();
  }

  @Override
  public String getStatus() {
    if (legacyThermostat.isActive()) {
      return "LegacyThermostat is ON, temperature = " + legacyThermostat.getCurrentTemp();
    } else {
      return "LegacyThermostat is OFF, temperature = " + legacyThermostat.getCurrentTemp();
    }
  }
}
