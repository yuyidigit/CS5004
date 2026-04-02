package chess;

public class Rook extends ChessPiece {
  public Rook(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!inBounds(row, col) || !differentSquare(row, col)) return false;
    return row == getRow() || col == getColumn();
  }
}

