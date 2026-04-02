public class BasicEquipment implements Equipment {
  private String description;
  private int attackBonus;
  private int defenseBonus;

  public BasicEquipment(String description, int attackBonus, int defenseBonus) {
    this.description = description;
    this.attackBonus = attackBonus;
    this.defenseBonus = defenseBonus;
  }

  @Override
  public int getAttackBonus() {
    return attackBonus;
  }

  @Override
  public int getDefenseBonus() {
    return defenseBonus;
  }

  @Override
  public String getDescription() {
    return description;
  }
}
