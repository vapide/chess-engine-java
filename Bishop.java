public class Bishop extends Piece {
  // private Bitboard moves;
  public Bishop(boolean color, int row, int col) {
    super(color, row, col);
  }
  public Bitboard getMoves() {
    return new Bitboard((DIAG_AH >>> (col +  row) ^ (DIAG_HA << (7 - col + row));
  }
}
