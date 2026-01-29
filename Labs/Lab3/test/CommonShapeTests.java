import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public interface CommonShapeTests {
  Shape small();
  Shape sameAsSmall();
  Shape large();

  @Test
  default void testDistToOriginNonNegative() {
    assertTrue(small().distToOrigin() >= 0);
    assertTrue(large().distToOrigin() >= 0);
  }

  @Test
  default void testCompareToThreeOutcomes() {
    Shape s = small();
    Shape same = sameAsSmall();
    Shape l = large();

    assertTrue(s.compareTo(l) < 0);
    assertEquals(0, s.compareTo(same));
    assertTrue(l.compareTo(s) > 0);
  }
}
