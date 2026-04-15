import java.awt.Color;
import java.util.Objects;

public class Vehicle {
  private String make;
  private String model;
  private Integer year;
  private Color vehicleColor;

  /**
   * Constructor for a Vehicle object.
   *
   * @param make the make of the vehicle
   * @param model the model of the vehicle
   * @param year the manufacturing year of the vehicle
   * @param vehicleColor the color of the vehicle
   */
  public Vehicle(String make, String model, Integer year, Color vehicleColor) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.vehicleColor = vehicleColor;
  }

  /**
   * Returns the make of the vehicle.
   *
   * @return the make
   */
  public String getMake() {
    return make;
  }

  /**
   * Returns the model of the vehicle.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Returns the year of the vehicle.
   *
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Returns the color of the vehicle.
   *
   * @return the vehicle color
   */
  public Color getVehicleColor() {
    return vehicleColor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Vehicle)) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(getMake(), vehicle.getMake());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMake());
  }

  @Override
  public String toString() {
    return "Vehicle{"
        + "make='" + make + '\''
        + ", model='" + model + '\''
        + ", year=" + year
        + ", vehicleColor=" + vehicleColor
        + '}';
  }
}
