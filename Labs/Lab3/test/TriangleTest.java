import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest implements CommonShapeTests {
  private static final double EPS = 1e-6;

  @Test
  public void testAreaAndPerimeter345() {
    Triangle t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(12.0, t.getPerimeter(), EPS);
    assertEquals(6.0, t.getArea(), EPS);
  }

  @Test
  public void testCollinearTriangleAreaZero() {
    Triangle t = new Triangle(0, 0, 1, 1, 2, 2);
    assertEquals(0.0, t.getArea(), EPS);
    assertTrue(t.getPerimeter() > 0);
  }

  @Test
  public void testIdenticalPointsThrows() {
    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(0, 0, 0, 0, 1, 1));
    assertDoesNotThrow(
        () -> new Triangle(0, 0, 1, 0, 0, 1));
  }

  @Test
  public void testToStringContainsTriangle() {
    Triangle t = new Triangle(0, 0, 1, 0, 0, 1);
    String s = t.toString();
    assertNotNull(s);
    assertTrue(s.toLowerCase().contains("triangle"));
  }

  @Override
  public Shape small() { return new Triangle(0,0, 1,0, 0,1); }       // area=0.5
  @Override
  public Shape sameAsSmall() { return new Triangle(0,0, 1,0, 0,1); } // area=0.5
  @Override
  public Shape large() { return new Triangle(0,0, 3,0, 0,4); }       // area=6
}

