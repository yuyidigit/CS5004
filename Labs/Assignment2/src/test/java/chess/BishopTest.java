package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {

  @Test
  void testCanMoveDiagonal() {
    Bishop b = new Bishop(3, 3, Color.WHITE);
    assertTrue(b.canMove(6, 6));
    assertTrue(b.canMove(0, 0));
    assertFalse(b.canMove(3, 3)); // 原地
    assertFalse(b.canMove(3, 4)); // 非对角
  }

  @Test
  void testCanKill() {
    Bishop b = new Bishop(2, 2, Color.WHITE);
    Pawn enemy = new Pawn(4, 4, Color.BLACK);
    Pawn friend = new Pawn(4, 4, Color.WHITE);

    assertTrue(b.canKill(enemy));
    assertFalse(b.canKill(friend));
  }
}

