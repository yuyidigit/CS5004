/**
 * Represents a shoe with a kind, color, brand, and size.
 */
public class Shoe {
  private final Kind kind;
  private final Color color;
  private final Brand brand;
  private final double size;

  /**
   * Constructs a Shoe.
   *
   * @param kind  the kind of shoe
   * @param color the color of shoe
   * @param brand the brand of shoe
   * @param size  the shoe size
   * @throws IllegalArgumentException if brand is NIKE and kind is DRESS
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("NIKE does not sell dress shoes.");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /** @return the kind of this shoe */
  public Kind getKind() {
    return kind;
  }

  /** @return the color of this shoe */
  public Color getColor() {
    return color;
  }

  /** @return the brand of this shoe */
  public Brand getBrand() {
    return brand;
  }

  /** @return the size of this shoe */
  public double getSize() {
    return size;
  }

  @Override
  public String toString() {
    String kindStr;
    switch (kind) {
      case DRESS:
        kindStr = "Dress";
        break;
      case SNEAKER:
        kindStr = "Sneaker";
        break;
      case RUNNING:
        kindStr = "Running";
        break;
      case BOOT:
        kindStr = "Boot";
        break;
      default:
        kindStr = titleCaseEnum(kind);
        break;
    }

    String brandStr;
    switch (brand) {
      case NIKE:
        brandStr = "Nike";
        break;
      case ADIDAS:
        brandStr = "Adidas";
        break;
      default:
        brandStr = titleCaseEnum(brand);
        break;
    }

    String colorStr;
    switch (color) {
      case BLACK:
        colorStr = "Black";
        break;
      case WHITE:
        colorStr = "White";
        break;
      // Intentionally rely on default for other colors (e.g., Pastel, Neutral).
      default:
        colorStr = titleCaseEnum(color);
        break;
    }

    return "Shoe{kind=" + kindStr
        + ", color=" + colorStr
        + ", brand=" + brandStr
        + ", size=" + size
        + "}";
  }

  private static String titleCaseEnum(Enum<?> e) {
    String s = e.name().toLowerCase();
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }
}
