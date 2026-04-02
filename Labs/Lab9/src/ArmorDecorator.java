public class ArmorDecorator extends GameCharacter {
  private GameCharacter character;
  private Equipment armor;

  public ArmorDecorator(GameCharacter character, Equipment armor) {
    super(
        character.getName(),
        character.getHealth(),
        character.getAttack() + armor.getAttackBonus(),
        character.getDefense() + armor.getDefenseBonus()
    );
    this.character = character;
    this.armor = armor;
  }

  @Override
  public GameCharacter clone() {
    return new ArmorDecorator(character.clone(), armor);
  }

  @Override
  public String getDescription() {
    String base = character.getDescription();

    int left = base.indexOf('[');
    int right = base.indexOf(']');

    String prefix = base;
    String suffix = "";

    if (left != -1 && right != -1 && right > left) {
      prefix = base.substring(0, left).trim();
      suffix = base.substring(right + 1).trim();
    }

    String result = prefix + " [HP=" + health + ", ATK=" + attack + ", DEF=" + defense + "]";

    if (!suffix.isEmpty()) {
      result += " " + suffix;
    }

    result += " + Armor(" + armor.getDescription() + ")";
    return result;
  }
}