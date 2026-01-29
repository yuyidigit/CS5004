public abstract class AbstractShape implements Shape {
  protected final Point2D reference;

  protected AbstractShape(Point2D reference) {
    if (reference == null) {
      throw new IllegalArgumentException("reference point cannot be null");
    }
    this.reference = reference;
  }

  @Override
  public double distToOrigin() {
    return reference.distToOrigin();
  }

  @Override
  public int compareTo(Shape other) {
    if (other == null) {
      throw new IllegalArgumentException("other shape cannot be null");
    }
    return Double.compare(this.getArea(), other.getArea());
  }
}

