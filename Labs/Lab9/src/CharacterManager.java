public class CharacterManager {

  public static void runDemo() {
    System.out.println("=== Problem 2 Demo ===");

    // Factory Method
    CharacterFactory factory = new CharacterFactory();
    GameCharacter tank = factory.createCharacter("tank");
    GameCharacter dps = factory.createCharacter("dps");
    GameCharacter support = factory.createCharacter("support");

    System.out.println("\nFactory characters:");
    System.out.println(tank.getDescription());
    System.out.println(dps.getDescription());
    System.out.println(support.getDescription());

    // Prototype
    GameCharacter clonedTank = tank.clone();
    clonedTank.setName("Cloned Tank");
    clonedTank.setHealth(180);

    System.out.println("\nCloned character:");
    System.out.println(clonedTank.getDescription());

    // Builder + Decorator
    Equipment sword = new BasicEquipment("Sword", 10, 0);
    Equipment armor = new BasicEquipment("Steel Armor", 0, 12);

    GameCharacter customWarrior = new CharacterBuilder("warrior")
        .setName("Custom Warrior")
        .setHealth(130)
        .setAttack(28)
        .setDefense(22)
        .addEquipment(sword)
        .addEquipment(armor)
        .build();

    System.out.println("\nBuilt and decorated character:");
    System.out.println(customWarrior.getDescription());

    // Direct decoration example
    GameCharacter decoratedDps = new WeaponDecorator(dps, new BasicEquipment("Magic Bow", 15, 0));
    decoratedDps = new ArmorDecorator(decoratedDps, new BasicEquipment("Light Armor", 0, 5));

    System.out.println("\nDirectly decorated character:");
    System.out.println(decoratedDps.getDescription());
  }
}
