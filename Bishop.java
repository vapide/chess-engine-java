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
     return this.pieceColor;
   }
  
   public int getRow() {
     return this.pieceRow;
   }
  
   public int getCol() {
     return this.pieceCol;
   }
  
  public void changeRow(int row) {
    pieceRow = row;
  }

  public void changeCol(int col) {
    pieceCol = col;
  }

  public char getSymbol() {
      if(this.pieceColor) {
          return 'B';
      } else {
          return 'b';
      }
  }

   @Override
   public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
       return true;
    }
  public Bitboard getMoves() {
    return new Bitboard(Bitboard.DIAG_AH >>> (pieceCol +  pieceRow) ^ (Bitboard.DIAG_HA << (7 - pieceCol + pieceRow)));
  }
}
