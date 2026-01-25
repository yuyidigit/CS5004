import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShoeTest {

  @Test
  public void testConstructorAndGetters() {
    Shoe s = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.NIKE, 9.5);

    assertEquals(Kind.SNEAKER, s.getKind());
    assertEquals(Color.BLACK, s.getColor());
    assertEquals(Brand.NIKE, s.getBrand());
    assertEquals(9.5, s.getSize(), 0.0001);
  }

  @Test
  public void testNikeDressThrowsException() {
    IllegalArgumentException ex = assertThrows(
        IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.WHITE, Brand.NIKE, 8.0)
    );
    assertTrue(ex.getMessage().toLowerCase().contains("nike"));
  }

  @Test
  public void testToStringIncludesAllAttributes() {
    Shoe s = new Shoe(Kind.BOOT, Color.NEUTRAL, Brand.ADIDAS, 7.0);
    String out = s.toString();

    assertTrue(out.contains("Boot"));
    assertTrue(out.contains("Neutral")); // default-case color formatting
    assertTrue(out.contains("Adidas"));
    assertTrue(out.contains("7.0"));
  }
}
