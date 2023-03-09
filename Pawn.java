public class Pawn extends Piece {
private boolean pieceColor;
private int pieceRow;
 private int pieceCol;
 public Pawn(boolean color, int row, int col) {
  super(color, row, col);
  pieceColor = color;
  pieceRow = row;
  pieceCol = col;
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

 @Override
 public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
     return false;
  }
}