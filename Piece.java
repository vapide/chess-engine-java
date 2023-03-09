public abstract class Piece {

  private boolean color;
  private int row;
  private int col;

  public Piece(boolean color, int row, int col) {
    this.color = color;
    this.row = row;
    this.col = col;
  }

  public boolean getColor() {
    return color;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public abstract boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol);
}
