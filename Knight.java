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
/*
  public Bitboard getPsudeoLegalMoves(Chessboard board, boolean color) { // do inverse of same color pieces bitboard then and it with the legal moves
    return color ? (!board.getWhitePieces() && 0b10100001000100000000000100010000101L >> (Long.numberOfTrailingZeros(row * 8 + col) - 17)) : (!board.getBlackPieces() && 0b10100001000100000000000100010000101L >> (Long.numberOfTrailingZeros(row * 8 + col) - 17));
  }
*/
/*
public Bitboard getLegalMoves(Board board, int row, int col, boolean color) {
    // Calculate the number of zeroes before the 1
    int n = Long.numberOfTrailingZeros(row * 8 + col);
    // Calculate the mask to shift the bitboard by
    long mask = 0b0000000000000000000000000000000000000000000000000000000111110010L << (n-17);
    // Shift the bitboard by the mask to get the possible knight moves
    long moves = 0b10100001000100000000000100010000101L >> (n - 17) & (~(color ? board.getWhitePieces() : board.getBlackPieces()));
    // Return the possible knight moves
    return new Bitboard(moves);
}

     @Override
     public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
         return ((color ? board.getWhiteKnights() : board.getBlackKnights()) & (0b1L >> (startrow * 8 + startcol))) & (getLegalMoves(board, startrow, startcol, color) & (0b1L >> (endrow * 8 + endcol)));
      }
    }
*/

public Bitboard getLegalMoves(Board board, int row, int col, boolean color) {
    // Calculate the number of zeroes before the 1
    int n = Long.numberOfTrailingZeros(row * 8 + col);
    // Calculate the mask to shift the bitboard by
    long mask = 0b0000000000000000000000000000000000000000000000000000000111110010L << (n-17);
    // Shift the bitboard by the mask to get the possible knight moves
    long moves = 0b10100001000100000000000100010000101L >> (n - 17) & (~(color ? board.getWhitePieces() : board.getBlackPieces()));
    // Return the possible knight moves as a new Bitboard object
    return new Bitboard(moves);
}

@Override
public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
    return ((color ? board.getWhiteKnights() : board.getBlackKnights()) & (0b1L >> (startrow * 8 + startcol))) != 0 && (getLegalMoves(board, startrow, startcol, color) & (0b1L >> (endrow * 8 + endcol))) != 0;
}


//0b00000000000000000010100001000100000x0000010001000010100000000000

//0b00000000010100001000100000x0000010001000010100000000000000000000