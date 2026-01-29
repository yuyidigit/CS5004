public class Triangle extends AbstractShape {
  private final Point2D p1;
  private final Point2D p2;
  private final Point2D p3;

  // Construct with 3 points (also provides an overload with 6 coordinates).
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    this(new Point2D(x1, y1), new Point2D(x2, y2), new Point2D(x3, y3));
  }

  public Triangle(Point2D p1, Point2D p2, Point2D p3) {
    super(p1); // The first point is the reference point.
    if (p1 == null || p2 == null || p3 == null) {
      throw new IllegalArgumentException("points cannot be null");
    }
    // If any two points are identical, throw IllegalArgumentException.
    if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) {
      throw new IllegalArgumentException("Triangle cannot have identical points");
    }
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  @Override
  public double getPerimeter() {
    return p1.distTo(p2) + p2.distTo(p3) + p3.distTo(p1);
  }

  @Override
  public double getArea() {
    double a = p1.distTo(p2);
    double b = p2.distTo(p3);
    double c = p3.distTo(p1);
    double s = (a + b + c) / 2.0;

    double inside = s * (s - a) * (s - b) * (s - c);
    inside = Math.max(0.0, inside); // Handle floating-point error for collinear points.
    return Math.sqrt(inside);
  }

  @Override
  public String toString() {
    return String.format("Triangle: p1=%s, p2=%s, p3=%s", p1, p2, p3);
  }
}
