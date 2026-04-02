package chess;

public class Knight extends ChessPiece {
  public Knight(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!inBounds(row, col) || !differentSquare(row, col)) return false;
    int dr = Math.abs(row - getRow());
    int dc = Math.abs(col - getColumn());
    return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
  }
}

