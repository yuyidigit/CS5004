public class CharacterFactory {

  public GameCharacter createCharacter(String type) {
    if (type == null) {
      return null;
    }

    if (type.equalsIgnoreCase("tank")) {
      return new Warrior("Tank Warrior", 150, 20, 40);
    } else if (type.equalsIgnoreCase("dps")) {
      return new Archer("DPS Archer", 100, 35, 15);
    } else if (type.equalsIgnoreCase("support")) {
      return new Mage("Support Mage", 90, 25, 20);
    }

    return null;
  }
}
