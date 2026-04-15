import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {
  private List<Vehicle> vehicles = new ArrayList<>();

  /**
   * Constructs an OlderVehiclesFilter with a list of vehicles.
   *
   * @param vehicles the list of vehicles to filter
   */
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * Constructs an OlderVehiclesFilter with three vehicle objects.
   *
   * @param vehicle1 the first vehicle
   * @param vehicle2 the second vehicle
   * @param vehicle3 the third vehicle
   */
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Filters vehicles manufactured before 1999 and returns their make, model,
   * and year as formatted strings.
   *
   * @return a list of formatted vehicle descriptions for vehicles older than 1999
   */
  public List<String> filterOlderVehicles() {
    return vehicles.stream()
        .filter(vehicle -> vehicle.getYear() < 1999)
        .map(vehicle -> vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear())
        .collect(Collectors.toList());
  }
}
