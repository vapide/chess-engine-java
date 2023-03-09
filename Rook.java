public class Rook extends Piece {
 //private Bitboard moves;
  public Rook(boolean color, int row, int col) {
   super(color, row, col);
    //bitboard = new Bitboard( 1L << (row * 8 + col));
  }
  
  public Bitboard getMoves() { // psuedo legal moves
   return new Bitboard((Bitboard.FILE_A >>> col) ^ (Bitboard.RANK_8 >>> row)); 
  }
 
 public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
return false;
  }
 }
}
/*

  if(color) {
   long whitePieces = board.getWhitePieces().getBitBoard() ^ (row * 8 + col);
   long blackPieces = board.getBlackPieces().getBitBoard();
   
  } else {
   long whitePieces = board.getWhitePieces().getBitBoard();
   long blackPieces = board.getBlackPieces().getBitBoard() ^ (row * 8 + col);

public class Rook extends Piece {

  private Bitboard bitboard;

  public Rook(String color, int row, int col) {
    super(color, row, col);
    bitboard = new Bitboard(1L << (row * 8 + col));
  }

  public boolean isValidMove(int row, int col) {
    if (row == getRow()) {
      // Moving horizontally
      long targetBitboard = 1L << (row * 8 + col);
      long occupiedBitboard = Chessboard.getOccupiedBitboard();
      long fileBitboard = Bitboard.FILE_A << (getRow() * 8);
      if ((bitboard.getBitboard() ^ targetBitboard) == 0) {
        // Moving to the same square is not a valid move
        return false;
      } else if (
        (fileBitboard & targetBitboard) != 0 &&
        (fileBitboard & occupiedBitboard) == 0
      ) {
        // Moving along a file with no pieces in between is a valid move
        return true;
      } else if (
        (occupiedBitboard & Bitboard.RANK_1 << (col)) == 0 ||
        (occupiedBitboard & Bitboard.RANK_8 << (col)) == 0
      ) {
        // Moving to an empty square or capturing an opponent's piece is a valid move
        return true;
      } else {
        // All other moves are not valid
        return false;
      }
    } else if (col == getCol()) {
      // Moving vertically
      long targetBitboard = 1L << (row * 8 + col);
      long occupiedBitboard = Chessboard.getOccupiedBitboard();
      long rankBitboard = Bitboard.RANK_1 << getCol();
      if ((bitboard.getBitboard() ^ targetBitboard) == 0) {
        // Moving to the same square is not a valid move
        return false;
      } else if (
        (rankBitboard & targetBitboard) != 0 &&
        (rankBitboard & occupiedBitboard) == 0
      ) {
        // Moving along a rank with no pieces in between is a valid move
        return true;
      } else if (
        (occupiedBitboard & Bitboard.FILE_A << (8 * (7 - row))) == 0 ||
        (occupiedBitboard & Bitboard.FILE_H << (8 * row)) == 0
      ) {
        // Moving to an empty square or capturing an opponent's piece is a valid move
        return true;
      } else {
        // All other moves are not valid
        return false;
      }
    } else {
      // Rooks can only move horizontally or vertically
      return false;
    }
  }
}
*/
