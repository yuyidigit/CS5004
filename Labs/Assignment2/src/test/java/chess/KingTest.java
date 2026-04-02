package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

  @Test
  void testCanMoveOneStep() {
    King k = new King(4, 4, Color.WHITE);
    assertTrue(k.canMove(5, 5));
    assertTrue(k.canMove(4, 5));
    assertTrue(k.canMove(3, 4));
    assertFalse(k.canMove(6, 4)); // 走两格不行
    assertFalse(k.canMove(4, 4)); // 原地
  }
}

