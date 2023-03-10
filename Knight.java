public class Knight extends Piece {
    private boolean pieceColor;
    private int pieceRow;
     private int pieceCol;
     public Knight(boolean color, int row, int col) {
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
          return 'N';
      } else {
          return 'n';
      }
  }

     @Override
     public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
         return true;
      }
    }
