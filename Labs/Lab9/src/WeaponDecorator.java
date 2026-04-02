public class WeaponDecorator extends GameCharacter {
  private GameCharacter character;
  private Equipment weapon;

  public WeaponDecorator(GameCharacter character, Equipment weapon) {
    super(
        character.getName(),
        character.getHealth(),
        character.getAttack() + weapon.getAttackBonus(),
        character.getDefense() + weapon.getDefenseBonus()
    );
    this.character = character;
    this.weapon = weapon;
  }

  @Override
  public GameCharacter clone() {
    return new WeaponDecorator(character.clone(), weapon);
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

    result += " + Weapon(" + weapon.getDescription() + ")";
    return result;
  }
}