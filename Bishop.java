public class Bishop extends Piece {
  private boolean pieceColor;
  private int pieceRow;
   private int pieceCol;
   public Bishop(boolean color, int row, int col) {
    super(color, row, col);
     //bitboard = new Bitboard( 1L << (row * 8 + col));
   }
  @Override
  public char getSymbol() {
      return getColor() ? 'B' : 'b';
  }

   @Override
   public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
       return true;
    }
  public Bitboard getMoves() {
    return new Bitboard(Bitboard.DIAG_AH >>> (pieceCol +  pieceRow) ^ (Bitboard.DIAG_HA << (7 - pieceCol + pieceRow)));
  }

    @Override
    public Bitboard getLegalMoves(Chessboard board, int row, int col, boolean color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
