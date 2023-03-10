public class Pawn extends Piece {
private boolean pieceColor;
private int pieceRow;
 private int pieceCol;
 public Pawn(boolean color, int row, int col) {
  super(color, row, col);
  this.pieceColor = color;
  this.pieceRow = row;
  this.pieceCol = col;
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
