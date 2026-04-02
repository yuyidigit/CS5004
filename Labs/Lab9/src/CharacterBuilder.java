import java.util.ArrayList;
import java.util.List;

public class CharacterBuilder {
  private String type;
  private String name;
  private int health;
  private int attack;
  private int defense;
  private List<Equipment> equipments;

  public CharacterBuilder(String type) {
    this.type = type;
    this.equipments = new ArrayList<>();
  }

  public CharacterBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CharacterBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public CharacterBuilder setAttack(int attack) {
    this.attack = attack;
    return this;
  }

  public CharacterBuilder setDefense(int defense) {
    this.defense = defense;
    return this;
  }

  public CharacterBuilder addEquipment(Equipment equipment) {
    equipments.add(equipment);
    return this;
  }

  public GameCharacter build() {
    GameCharacter character;

    if (type.equalsIgnoreCase("warrior")) {
      character = new Warrior(name, health, attack, defense);
    } else if (type.equalsIgnoreCase("mage")) {
      character = new Mage(name, health, attack, defense);
    } else {
      character = new Archer(name, health, attack, defense);
    }

    for (Equipment equipment : equipments) {
      if (equipment.getAttackBonus() > 0) {
        character = new WeaponDecorator(character, equipment);
      }
      if (equipment.getDefenseBonus() > 0) {
        character = new ArmorDecorator(character, equipment);
      }
    }

    return character;
  }
}
