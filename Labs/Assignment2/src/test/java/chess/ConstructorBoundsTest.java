package chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructorBoundsTest {

  @Test
  void testOutOfBoundsThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Rook(-1, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Rook(0, 8, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new King(8, 8, Color.BLACK));
  }

  @Test
  void testPawnRoyalRowThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 3, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Pawn(7, 3, Color.BLACK));
  }
}

