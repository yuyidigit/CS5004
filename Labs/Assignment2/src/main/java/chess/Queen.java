package chess;

public class Queen extends ChessPiece {
  public Queen(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!inBounds(row, col) || !differentSquare(row, col)) return false;
    int dr = Math.abs(row - getRow());
    int dc = Math.abs(col - getColumn());
    return (row == getRow()) || (col == getColumn()) || (dr == dc);
  }
}

