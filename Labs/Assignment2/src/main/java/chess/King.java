package chess;

public class King extends ChessPiece {
  public King(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!inBounds(row, col) || !differentSquare(row, col)) return false;
    int dr = Math.abs(row - getRow());
    int dc = Math.abs(col - getColumn());
    return Math.max(dr, dc) == 1;
  }
}

