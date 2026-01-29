import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest implements CommonShapeTests {
  private static final double EPS = 1e-6;

  @Test
  public void testAreaAndPerimeter() {
    Rectangle r = new Rectangle(0, 0, 3, 4);
    assertEquals(12.0, r.getArea(), EPS);
    assertEquals(14.0, r.getPerimeter(), EPS);
  }

  @Test
  public void testInvalidDimensionsThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Rectangle(0,0, 0, 1));
    assertThrows(IllegalArgumentException.class, () -> new Rectangle(0,0, 1, 0));
    assertDoesNotThrow(() -> new Rectangle(0,0, 1, 1));
  }

  @Test
  public void testToStringContainsRectangle() {
    Rectangle r = new Rectangle(0, 0, 1, 2);
    String s = r.toString();
    assertNotNull(s);
    assertTrue(s.toLowerCase().contains("rectangle"));
  }

  @Override
  public Shape small() { return new Rectangle(0,0, 1,1); }      // area=1
  @Override
  public Shape sameAsSmall() { return new Rectangle(0,0, 1,1); }
  @Override
  public Shape large() { return new Rectangle(0,0, 2,2); }      // area=4
}

