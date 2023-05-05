public class Pawn extends Piece {
private boolean pieceColor;
private int pieceRow;
 private int pieceCol;
 private boolean hasMoved;
 public Pawn(boolean color, int row, int col) {
  super(color, row, col);
  pieceColor = color;
  pieceRow = row;
  pieceCol = col;
  hasMoved = false;
   //bitboard = new Bitboard( 1L << (row * 8 + col));
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

public boolean checkHasMoved() {
  return hasMoved;
}

public void setHasMovedTrue() {
  hasMoved = true;
}

  public void changeRow(int row) {
    this.pieceRow = row;
  }

  public void changeCol(int col) {
    this.pieceCol = col;
  }

  public char getSymbol() {
      if(this.pieceColor) {
          return 'P';
      } else {
          return 'p';
      }
  }

 @Override
 public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
     return true;
  }
}
