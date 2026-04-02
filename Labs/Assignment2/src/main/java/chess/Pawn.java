package chess;

public class Pawn extends ChessPiece {
  public Pawn(int row, int column, Color color) {
    super(row, column, color);

    if (color == Color.WHITE && row == 0) {
      throw new IllegalArgumentException("White pawn cannot be on row 0");
    }
    if (color == Color.BLACK && row == 7) {
      throw new IllegalArgumentException("Black pawn cannot be on row 7");
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!inBounds(row, col) || !differentSquare(row, col)) return false;

    int dir = (getColor() == Color.WHITE) ? 1 : -1;
    int startRow = (getColor() == Color.WHITE) ? 1 : 6;

    if (col != getColumn()) return false;

    if (row == getRow() + dir) return true;

    return getRow() == startRow && row == getRow() + 2 * dir;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) return false;
    if (piece.getColor() == getColor()) return false;

    int dir = (getColor() == Color.WHITE) ? 1 : -1;

    return piece.getRow() == getRow() + dir
        && Math.abs(piece.getColumn() - getColumn()) == 1;
  }
}

