public class DeviceFactory {

  public SmartDevice createDevice(String type) {
    if (type == null) {
      return null;
    }

    if (type.equalsIgnoreCase("light")) {
      return new SmartLight();
    } else if (type.equalsIgnoreCase("speaker")) {
      return new SmartSpeaker();
    }

    return null;
  }
}
