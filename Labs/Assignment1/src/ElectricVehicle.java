import java.text.DecimalFormat;

/**
 * Represents an electric vehicle (EV) with battery, charge state, and efficiency.
 * Values are clamped to valid ranges instead of throwing exceptions.
 */
public class ElectricVehicle {
  private static final double MIN_BATTERY_SIZE = 10.0;
  private static final double MAX_BATTERY_SIZE = 150.0;

  private static final double MIN_DEFAULT_EFFICIENCY = 0.5;
  private static final double MAX_DEFAULT_EFFICIENCY = 4.5;

  private static final double MIN_SOC = 0.15;
  private static final double MAX_SOC = 1.0;

  private static final String UNKNOWN_NAME = "unknown EV";

  private final String name;
  private final double batterySize;
  private final double defaultEfficiency;

  private double stateOfCharge;     // decimal form, e.g. 0.50 = 50%
  private double currentEfficiency; // changes with temperature

  /**
   * Constructs an ElectricVehicle with clamped values.
   *
   * @param name the EV name (null/empty becomes "unknown EV")
   * @param batterySize battery size in kWh (clamped to [10.0, 150.0])
   * @param stateOfCharge decimal SoC (clamped to [0.15, 1.0])
   * @param defaultEfficiency rated efficiency (clamped to [0.5, 4.5])
   */
  public ElectricVehicle(String name, double batterySize, double stateOfCharge,
      double defaultEfficiency) {
    if (name == null || name.isEmpty()) {
      this.name = UNKNOWN_NAME;
    } else {
      this.name = name;
    }

    this.batterySize = clamp(batterySize, MIN_BATTERY_SIZE, MAX_BATTERY_SIZE);
    this.stateOfCharge = clamp(stateOfCharge, MIN_SOC, MAX_SOC);
    this.defaultEfficiency = clamp(defaultEfficiency, MIN_DEFAULT_EFFICIENCY, MAX_DEFAULT_EFFICIENCY);

    // Upon creation, current efficiency starts at default efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * Computes the current range (miles) as:
   * currentEfficiency * stateOfCharge * batterySize.
   *
   * @return the computed range in miles
   */
  public double range() {
    return this.currentEfficiency * this.stateOfCharge * this.batterySize;
  }

  /**
   * Updates current efficiency based on temperature (Fahrenheit).
   *
   * Rules:
   * - 65.0F <= temp <= 77.0F: 100% of default
   * - temp > 77.0F: 85% of default
   * - temp < 65.0F: reduce by 1% for every degree below 65, up to max 50% decrease
   *
   * @param currentTemp the current temperature in Fahrenheit
   */
  public void updateEfficiency(double currentTemp) {
    if (currentTemp >= 65.0 && currentTemp <= 77.0) {
      this.currentEfficiency = this.defaultEfficiency;
    } else if (currentTemp > 77.0) {
      this.currentEfficiency = this.defaultEfficiency * 0.85;
    } else {
      double degreesBelow = 65.0 - currentTemp;
      double factor = 1.0 - 0.01 * degreesBelow; // 1% per degree below 65
      if (factor < 0.5) {
        factor = 0.5; // max decrease 50%
      }
      this.currentEfficiency = this.defaultEfficiency * factor;
    }
  }

  /** @return the CURRENT efficiency (not default efficiency). */
  public double getEfficiency() {
    return this.currentEfficiency;
  }

  /** @return the battery size in kWh. */
  public double getBatterySize() {
    return this.batterySize;
  }

  /** @return the current state of charge in decimal form (e.g., 0.5 for 50%). */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }

  /** @return the EV name. */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the state of charge (decimal form), clamped to [0.15, 1.0].
   *
   * @param stateOfCharge new SoC in decimal form
   */
  public void setStateOfCharge(double stateOfCharge) {
    this.stateOfCharge = clamp(stateOfCharge, MIN_SOC, MAX_SOC);
  }

  /**
   * Returns a string describing the EV's name, SoC (percent), and range.
   * Example:
   * Ford MachE SOC: 50.0% Range (miles): 131.8
   *
   * @return formatted EV string
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.0");
    double socPercent = this.stateOfCharge * 100.0;
    return this.name
        + " SOC: " + df.format(socPercent) + "% "
        + "Range (miles): " + df.format(this.range());
  }

  private static double clamp(double value, double min, double max) {
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }
}

