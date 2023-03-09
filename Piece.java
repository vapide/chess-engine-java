public abstract class Piece {

  private boolean color;
  private int row;
  private int col;

  public Piece(boolean color, int row, int col) {
    this.color = color;
    this.row = row;
    this.col = col;
  }

  public String getColor() {
    return color;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public abstract boolean isValidMove(int row, int col);
}
