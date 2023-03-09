public class Chessboard {

  private Bitboard whitePawns;
  private Bitboard whiteKnights;
  private Bitboard whiteBishops;
  private Bitboard whiteRooks;
  private Bitboard whiteQueens;
  private Bitboard whiteKing;
  private Bitboard whitePieces;

  private Bitboard blackPawns;
  private Bitboard blackKnights;
  private Bitboard blackBishops;
  private Bitboard blackRooks;
  private Bitboard blackQueens;
  private Bitboard blackKing;
  private Bitboard blackPieces;

  private Bitboard allPieces;

  public Chessboard() {
    whitePawns = new Bitboard(0b0000000000000000000000000000000000000000000000001111111100000000L);
    whiteKnights = new Bitboard(0b0000000000000000000000000000000000000000000000000000000001000010L);
    whiteBishops = new Bitboard(0b0000000000000000000000000000000000000000000000000000000000100100L);
    whiteRooks = new Bitboard(0b0000000000000000000000000000000000000000000000000000000010000001L);
    whiteQueens = new Bitboard(0b0000000000000000000000000000000000000000000000000000000000010000L);
    whiteKing = new Bitboard(0b0000000000000000000000000000000000000000000000000000000000001000L);
    whitePieces = new Bitboard(whitePawns.getBitboard() | whiteKnights.getBitboard() | whiteBishops.getBitboard() | whiteRooks.getBitboard() | whiteQueens.getBitboard() | whiteKing.getBitboard());
   
    
    blackPawns = new Bitboard(0b0000000011111111000000000000000000000000000000000000000000000000L);
    blackKnights = new Bitboard(0b0100001000000000000000000000000000000000000000000000000000000000L);
    blackBishops = new Bitboard(0b0010010000000000000000000000000000000000000000000000000000000000L);
    blackRooks = new Bitboard(0b1000000100000000000000000000000000000000000000000000000000000000L);
    blackQueens = new Bitboard(0b0001000000000000000000000000000000000000000000000000000000000000L);
    blackKing = new Bitboard(0b0000100000000000000000000000000000000000000000000000000000000000L);
    blackPieces = new Bitboard(blackPawns.getBitboard() | blackKnights.getBitboard() | blackBishops.getBitboard() | blackRooks.getBitboard() | blackQueens.getBitboard() | blackKing.getBitboard());
    
    allPieces = new Bitboard(whitePieces.getBitboard() | blackPieces.getBitboard());
    
  }

  public void displayBoard() {
    for (int i = 7; i >= 0; i--) {
      for (int j = 7; j >= 0; j--) {
        long mask = 1L << (i * 8 + j);
        if ((whitePawns.getBitboard() & mask) != 0) {
          System.out.print("P ");
        } else if ((whiteKnights.getBitboard() & mask) != 0) {
          System.out.print("N ");
        } else if ((whiteBishops.getBitboard() & mask) != 0) {
          System.out.print("B ");
        } else if ((whiteRooks.getBitboard() & mask) != 0) {
          System.out.print("R ");
        } else if ((whiteQueens.getBitboard() & mask) != 0) {
          System.out.print("Q ");
        } else if ((whiteKing.getBitboard() & mask) != 0) {
          System.out.print("K ");
        } else if ((blackPawns.getBitboard() & mask) != 0) {
          System.out.print("p ");
        } else if ((blackKnights.getBitboard() & mask) != 0) {
          System.out.print("n ");
        } else if ((blackBishops.getBitboard() & mask) != 0) {
          System.out.print("b ");
        } else if ((blackRooks.getBitboard() & mask) != 0) {
          System.out.print("r ");
        } else if ((blackQueens.getBitboard() & mask) != 0) {
          System.out.print("q ");
        } else if ((blackKing.getBitboard() & mask) != 0) {
          System.out.print("k ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
