public class Pawn extends Piece {
@SuppressWarnings({"unused", "FieldMayBeFinal"})
private boolean hasMoved;
 public Pawn(boolean color, int row, int col) {
  super(color, row, col);
  hasMoved = false;
   //bitboard = new Bitboard( 1L << (row * 8 + col));
 }

@Override
  public char getSymbol() {
      return getColor() ? 'P' : 'p';
  }

 @Override
 public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
     return true;
  }
}
