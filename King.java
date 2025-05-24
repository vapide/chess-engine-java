public class King extends Piece {
    @SuppressWarnings({"unused", "FieldMayBeFinal"})
    private int pieceRow;
    @SuppressWarnings({"unused", "FieldMayBeFinal"})
    private int pieceCol;
    @SuppressWarnings({"unused", "FieldMayBeFinal"})
     private boolean hasMoved;
     public King(boolean color, int row, int col) {
      super(color, row, col);
      hasMoved = false;
       //bitboard = new Bitboard( 1L << (row * 8 + col));
     }
    
    public boolean checkHasMoved() {
        return hasMoved;
    }

  @Override
  public char getSymbol() {
      return getColor() ? 'K' : 'k';
  }

     @Override
     public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
         return true;
      }
    }
