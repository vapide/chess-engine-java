public class Bishop extends Piece {
  private boolean pieceColor;
  private int pieceRow;
   private int pieceCol;
   public Bishop(boolean color, int row, int col) {
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
  public Bitboard getMoves() {
    return new Bitboard(Bitboard.DIAG_AH >>> (pieceCol +  pieceRow) ^ (Bitboard.DIAG_HA << (7 - pieceCol + pieceRow)));
  }
}
