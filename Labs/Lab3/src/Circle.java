public class Circle extends AbstractShape {
  private final double radius;

  public Circle(double x, double y, double radius) {
    this(new Point2D(x, y), radius);
  }

  public Circle(Point2D center, double radius) {
    super(center);
    if (radius <= 0) {
      throw new IllegalArgumentException("radius must be > 0");
    }
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public String toString() {
    return String.format("Circle: center=%s, r=%.2f", reference, radius);
  }
}
