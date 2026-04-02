public class Main {
  public static void main(String[] args) {
    // Problem 1
    DeviceFactory factory = new DeviceFactory();
    SmartDevice light = factory.createDevice("light");
    SmartDevice speaker = factory.createDevice("speaker");

    LegacyThermostat legacyThermostat = new LegacyThermostat();
    SmartDevice thermostatAdapter = new LegacyThermostatAdapter(legacyThermostat);

    SmartHomeController controller = SmartHomeController.getInstance();
    controller.addDevice(light);
    controller.addDevice(speaker);
    controller.addDevice(thermostatAdapter);

    System.out.println("=== Initial Status ===");
    controller.showAllStatuses();

    System.out.println("\n=== Turn All On ===");
    controller.turnAllOn();
    controller.showAllStatuses();

    SmartHomeFacade facade = new SmartHomeFacade();

    System.out.println("\n=== Night Mode ===");
    facade.activateNightMode();
    facade.showStatuses();

    System.out.println("\n=== Arrive Home ===");
    facade.arriveHome();
    facade.showStatuses();

    System.out.println("\n=== Leave Home ===");
    facade.leaveHome();
    facade.showStatuses();

    // Problem 2
    System.out.println("\n==============================");
    CharacterManager.runDemo();
  }
}