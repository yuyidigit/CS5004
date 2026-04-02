package chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

  @Test
  void testWhitePawnMove() {
    Pawn p = new Pawn(1, 3, Color.WHITE);
    assertTrue(p.canMove(2, 3));  // 前进一步
    assertTrue(p.canMove(3, 3));  // 起始行可两步
    assertFalse(p.canMove(0, 3)); // 不能后退
    assertFalse(p.canMove(2, 4)); // 不能斜走当作移动
  }

  @Test
  void testBlackPawnMove() {
    Pawn p = new Pawn(6, 3, Color.BLACK);
    assertTrue(p.canMove(5, 3));
    assertTrue(p.canMove(4, 3));
    assertFalse(p.canMove(7, 3));
  }

  @Test
  void testPawnKillIsDiagonalOnly() {
    Pawn white = new Pawn(3, 3, Color.WHITE);
    Rook enemyDiag = new Rook(4, 4, Color.BLACK);
    Rook enemyStraight = new Rook(4, 3, Color.BLACK);

    assertTrue(white.canKill(enemyDiag));
    assertFalse(white.canKill(enemyStraight));
  }
}

