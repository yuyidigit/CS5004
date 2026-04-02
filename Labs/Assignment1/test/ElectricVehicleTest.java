import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for ElectricVehicle.
 */
public class ElectricVehicleTest {

  private static final double EPS = 1e-9;

  /** Battery size should be clamped to minimum 10.0. */
  @Test
  public void testBatterySizeClampLow() {
    ElectricVehicle ev = new ElectricVehicle("A", 1.0, 0.5, 2.0);
    assertEquals(10.0, ev.getBatterySize(), EPS);
  }

  /** Battery size should be clamped to maximum 150.0. */
  @Test
  public void testBatterySizeClampHigh() {
    ElectricVehicle ev = new ElectricVehicle("A", 160.5, 0.5, 2.0);
    assertEquals(150.0, ev.getBatterySize(), EPS);
  }

  /** Default efficiency should be clamped to [0.5, 4.5]. */
  @Test
  public void testDefaultEfficiencyClamp() {
    ElectricVehicle evLow = new ElectricVehicle("A", 100.0, 0.5, 0.1);
    assertEquals(0.5, evLow.getEfficiency(), EPS); // starts at default

    ElectricVehicle evHigh = new ElectricVehicle("A", 100.0, 0.5, 10.0);
    assertEquals(4.5, evHigh.getEfficiency(), EPS); // starts at default
  }

  /** Name should become "unknown EV" when null or empty. */
  @Test
  public void testNameUnknown() {
    ElectricVehicle ev1 = new ElectricVehicle(null, 100.0, 0.5, 2.0);
    assertEquals("unknown EV", ev1.getName());

    ElectricVehicle ev2 = new ElectricVehicle("", 100.0, 0.5, 2.0);
    assertEquals("unknown EV", ev2.getName());
  }

  /** State of charge should be clamped to [0.15, 1.0] in constructor. */
  @Test
  public void testSocClampInConstructor() {
    ElectricVehicle evLow = new ElectricVehicle("A", 100.0, 0.01, 2.0);
    assertEquals(0.15, evLow.getStateOfCharge(), EPS);

    ElectricVehicle evHigh = new ElectricVehicle("A", 100.0, 2.0, 2.0);
    assertEquals(1.0, evHigh.getStateOfCharge(), EPS);
  }

  /** setStateOfCharge should clamp values. */
  @Test
  public void testSetSocClamps() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.5, 2.0);
    ev.setStateOfCharge(0.0);
    assertEquals(0.15, ev.getStateOfCharge(), EPS);

    ev.setStateOfCharge(5.0);
    assertEquals(1.0, ev.getStateOfCharge(), EPS);
  }

  /** Range should be currentEfficiency * stateOfCharge * batterySize. */
  @Test
  public void testRangeComputation() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.5, 2.0); // currentEfficiency=2.0
    assertEquals(2.0 * 0.5 * 100.0, ev.range(), EPS);
  }

  /** updateEfficiency: 65-77 inclusive should be 100% of default. */
  @Test
  public void testUpdateEfficiencyComfortRange() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.5, 2.0);
    ev.updateEfficiency(65.0);
    assertEquals(2.0, ev.getEfficiency(), EPS);

    ev.updateEfficiency(77.0);
    assertEquals(2.0, ev.getEfficiency(), EPS);
  }

  /** updateEfficiency: above 77 should be 85% of default. */
  @Test
  public void testUpdateEfficiencyHot() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.5, 2.0);
    ev.updateEfficiency(77.1);
    assertEquals(2.0 * 0.85, ev.getEfficiency(), EPS);
  }

  /** updateEfficiency: below 65 reduces 1% per degree, supports fractional. */
  @Test
  public void testUpdateEfficiencyColdFractional() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.5, 2.0);
    ev.updateEfficiency(64.1); // 0.9 degrees below -> 99.1%
    assertEquals(2.0 * 0.991, ev.getEfficiency(), EPS);
  }

  /** updateEfficiency: efficiency should not drop below 50% of default. */
  @Test
  public void testUpdateEfficiencyColdMin50Percent() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.5, 2.0);
    ev.updateEfficiency(0.0);
    assertEquals(2.0 * 0.5, ev.getEfficiency(), EPS);

    ev.updateEfficiency(15.0);
    assertEquals(2.0 * 0.5, ev.getEfficiency(), EPS);
  }

  /** toString should match required formatting with 1 decimal place. */
  @Test
  public void testToStringFormatExample() {
    ElectricVehicle ev = new ElectricVehicle("Ford MachE", 100.0, 0.5, 2.636);
    assertEquals("Ford MachE SOC: 50.0% Range (miles): 131.8", ev.toString());
  }
}
