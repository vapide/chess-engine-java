public class King extends Piece {
    private boolean pieceColor;
    private int pieceRow;
     private int pieceCol;
     private boolean hasMoved;
     public King(boolean color, int row, int col) {
      super(color, row, col);
      pieceColor = color;
      pieceRow = row;
      pieceCol = col;
      hasMoved = false;
       //bitboard = new Bitboard( 1L << (row * 8 + col));
     }
     
     public boolean getColor() {
       return this.pieceColor;
     }
    
public boolean checkHasMoved() {
  return hasMoved;
}

public void setHasMovedTrue() {
  hasMoved = true;
}

     public int getRow() {
       return this.pieceRow;
     }
    
     public int getCol() {
       return this.pieceCol;
     }
    
  public char getSymbol() {
      if(this.pieceColor) {
          return 'K';
      } else {
          return 'k';
      }
  }

     @Override
     public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
         return true;
      }
    }
