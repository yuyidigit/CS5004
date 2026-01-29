import java.util.Objects;

public class Point2D {
  private final double x;
  private final double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() { return x; }
  public double getY() { return y; }

  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  public double distTo(Point2D other) {
    double dx = x - other.x;
    double dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point2D)) return false;
    Point2D p = (Point2D) o;
    return Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return String.format("(%.2f, %.2f)", x, y);
  }
}

