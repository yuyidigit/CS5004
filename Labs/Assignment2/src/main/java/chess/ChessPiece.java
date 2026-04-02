package chess;

public abstract class ChessPiece implements ChessPieceContract {
  private final int row;
  private final int column;
  private final Color color;

  protected ChessPiece(int row, int column, Color color) {
    if (color == null) {
      throw new IllegalArgumentException("color cannot be null");
    }
    if (!inBounds(row, column)) {
      throw new IllegalArgumentException("row/column out of bounds");
    }
    this.row = row;
    this.column = column;
    this.color = color;
  }

  protected static boolean inBounds(int r, int c) {
    return r >= 0 && r <= 7 && c >= 0 && c <= 7;
  }

  protected boolean differentSquare(int r, int c) {
    return r != this.row || c != this.column;
  }

  @Override
  public int getRow() { return row; }

  @Override
  public int getColumn() { return column; }

  @Override
  public Color getColor() { return color; }

  // 默认吃子规则（Pawn 需要 override）
  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) return false;
    if (this.color == piece.getColor()) return false;
    return this.canMove(piece.getRow(), piece.getColumn());
  }
}

