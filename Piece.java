public abstract class Piece {

  private boolean pieceColor;
  private int pieceRow;
  private int pieceCol;

  public Piece(boolean color, int row, int col) {
    this.pieceColor = color;
    this.pieceRow = row;
    this.pieceCol = col;
  }

  public boolean getColor() {
    return pieceColor;
  }

  public int getRow() {
    return pieceRow;
  }

  public int getCol() {
    return pieceCol;
  }

  public void changeRow(int row) {
    pieceRow = row;
  }

  public void changeCol(int col) {
    pieceCol = col;
  }

  public abstract boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol);
}
