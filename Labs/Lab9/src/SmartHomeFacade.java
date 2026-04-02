public class SmartHomeFacade {
  private SmartHomeController controller;

  public SmartHomeFacade() {
    controller = SmartHomeController.getInstance();
  }

  public void activateNightMode() {
    System.out.println("Activating night mode...");
    controller.turnAllOff();
  }

  public void leaveHome() {
    System.out.println("Leaving home...");
    controller.turnAllOff();
  }

  public void arriveHome() {
    System.out.println("Arriving home...");
    controller.turnAllOn();
  }

  public void showStatuses() {
    controller.showAllStatuses();
  }
}
