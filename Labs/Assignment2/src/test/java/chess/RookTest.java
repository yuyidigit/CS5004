package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

  @Test
  void testCanMoveStraight() {
    Rook r = new Rook(4, 4, Color.BLACK);
    assertTrue(r.canMove(4, 7));
    assertTrue(r.canMove(0, 4));
    assertFalse(r.canMove(5, 5));
    assertFalse(r.canMove(4, 4));
  }

  @Test
  void testCanKill() {
    Rook r = new Rook(4, 4, Color.BLACK);
    Queen enemy = new Queen(4, 1, Color.WHITE);
    Queen friend = new Queen(4, 1, Color.BLACK);

    assertTrue(r.canKill(enemy));
    assertFalse(r.canKill(friend));
  }
}

