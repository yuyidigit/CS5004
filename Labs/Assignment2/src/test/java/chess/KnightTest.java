package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

  @Test
  void testCanMoveLShape() {
    Knight n = new Knight(4, 4, Color.BLACK);
    assertTrue(n.canMove(6, 5));
    assertTrue(n.canMove(5, 6));
    assertTrue(n.canMove(2, 3));
    assertFalse(n.canMove(5, 5));
    assertFalse(n.canMove(4, 4));
  }
}

