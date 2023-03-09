public class Pawn extends Piece {

  public Pawn(String color, int row, int col) {
    super(color, row, col);
  }

  @Override
  public boolean isValidMove(int row, int col) {
    // Implement the rules for a pawn's move here
    return true;
  }
}
