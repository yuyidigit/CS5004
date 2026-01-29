import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest implements CommonShapeTests {
  private static final double EPS = 1e-6;

  @Test
  public void testAreaAndPerimeter() {
    Circle c = new Circle(0, 0, 2);
    assertEquals(Math.PI * 4, c.getArea(), EPS);
    assertEquals(2 * Math.PI * 2, c.getPerimeter(), EPS);
  }

  @Test
  public void testInvalidRadiusThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Circle(0, 0, 0));
    assertDoesNotThrow(() -> new Circle(0, 0, 1));
  }

  @Test
  public void testToStringContainsCircle() {
    Circle c = new Circle(1, 2, 3);
    String s = c.toString();
    assertNotNull(s);
    assertTrue(s.toLowerCase().contains("circle"));
  }

  @Override
  public Shape small() { return new Circle(0,0, 1); }      // area=pi
  @Override
  public Shape sameAsSmall() { return new Circle(0,0, 1); }
  @Override
  public Shape large() { return new Circle(0,0, 2); }      // area=4pi
}
