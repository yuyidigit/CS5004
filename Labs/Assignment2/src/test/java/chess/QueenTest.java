package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

  @Test
  void testCanMove() {
    Queen q = new Queen(3, 3, Color.WHITE);
    assertTrue(q.canMove(3, 7)); // 横
    assertTrue(q.canMove(7, 3)); // 竖
    assertTrue(q.canMove(6, 6)); // 对角
    assertFalse(q.canMove(5, 6)); // 乱走
    assertFalse(q.canMove(3, 3)); // 原地
  }
}

