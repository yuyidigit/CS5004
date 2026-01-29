public class Rectangle extends AbstractShape {
  private final double width;
  private final double height;

  public Rectangle(double x, double y, double width, double height) {
    this(new Point2D(x, y), width, height);
  }

  public Rectangle(Point2D referenceCorner, double width, double height) {
    super(referenceCorner);
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("width and height must be > 0");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  @Override
  public double getPerimeter() {
    return 2 * (width + height);
  }

  @Override
  public String toString() {
    return String.format("Rectangle: ref=%s, w=%.2f, h=%.2f", reference, width, height);
  }
}

