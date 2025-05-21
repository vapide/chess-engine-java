public class Queen extends Piece {
     public Queen(boolean color, int row, int col) {
      super(color, row, col);
       //bitboard = new Bitboard( 1L << (row * 8 + col));
     }
     
@Override
  public char getSymbol() {
      return getColor() ? 'Q' : 'q';
  }

     @Override
     public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
         return true;
      }
    }
