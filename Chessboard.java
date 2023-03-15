import java.util.*;
import java.util.ArrayList;
import java.util.List;

  public class Chessboard {

    public List<String> moves;

    private Piece[][] boardMatrix;

    private Hashtable<Character, Integer> fileCodes;
    private Hashtable<Integer, Character> letterCodes;
    
    private Hashtable<String, Bitboard> bbdict;
    
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

    private Bitboard[][] bitboardMatrix;


    public Chessboard() {
      moves = new ArrayList<>();

      whitePawns = new Bitboard(65280L); // 0b0000000000000000000000000000000000000000000000001111111100000000L
      whiteKnights = new Bitboard(66L); // 0b0000000000000000000000000000000000000000000000000000000001000010L
      whiteBishops = new Bitboard(36L); // 0b0000000000000000000000000000000000000000000000000000000000100100L
      whiteRooks = new Bitboard(129L); // 0b0000000000000000000000000000000000000000000000000000000010000001L
      whiteQueens = new Bitboard(16L); // 0b0000000000000000000000000000000000000000000000000000000000010000L
      whiteKing = new Bitboard(8L); // 0b0000000000000000000000000000000000000000000000000000000000001000L
      whitePieces = new Bitboard(whitePawns.getBitboard() | whiteKnights.getBitboard() | whiteBishops.getBitboard() | whiteRooks.getBitboard() | whiteQueens.getBitboard() | whiteKing.getBitboard());
    
      
      blackPawns = new Bitboard(71776119061217280L); // 0b0000000011111111000000000000000000000000000000000000000000000000L
      blackKnights = new Bitboard(4755801206503243776L); // 0b0100001000000000000000000000000000000000000000000000000000000000L
      blackBishops = new Bitboard(2594073385365405696L); // 0b0010010000000000000000000000000000000000000000000000000000000000L
      blackRooks = new Bitboard(-9151314442816847872L); // 0b1000000100000000000000000000000000000000000000000000000000000000L
      blackQueens = new Bitboard(1152921504606846976L); // 0b0001000000000000000000000000000000000000000000000000000000000000L
      blackKing = new Bitboard(576460752303423488L); // 0b0000100000000000000000000000000000000000000000000000000000000000L
      blackPieces = new Bitboard(blackPawns.getBitboard() | blackKnights.getBitboard() | blackBishops.getBitboard() | blackRooks.getBitboard() | blackQueens.getBitboard() | blackKing.getBitboard());
      
      allPieces = new Bitboard(whitePieces.getBitboard() | blackPieces.getBitboard());
      
      fileCodes = new Hashtable<Character, Integer>();
      letterCodes = new Hashtable<Integer, Character>();

      String files = "abcdefgh";
      char[] filelist = files.toCharArray();
      int j = 0; 
      for(char character : filelist) {
        fileCodes.put(character, j);
        letterCodes.put(j, character);
        j++;
      }

      boardMatrix = new Piece[8][8];

      for(int i=0;i<8;i++) {
        boardMatrix[1][i] = new Pawn(false, 1, i);
        boardMatrix[6][i] = new Pawn(true, 6, i);
      }
      boardMatrix[0][0] = new Rook(false,0,0);
      boardMatrix[0][1] = new Knight(false,0,1);
      boardMatrix[0][2] = new Bishop(false,0,2);
      boardMatrix[0][3] = new Queen(false,0,3);
      boardMatrix[0][4] = new King(false,0,4);
      boardMatrix[0][5] = new Bishop(false,0,5);
      boardMatrix[0][6] = new Knight(false,0,6);
      boardMatrix[0][7] = new Rook(false,0,7);
      boardMatrix[7][0] = new Rook(true,7,0);
      boardMatrix[7][1] = new Knight(true,7,1);
      boardMatrix[7][2] = new Bishop(true,7,2);
      boardMatrix[7][3] = new Queen(true,7,3);
      boardMatrix[7][4] = new King(true,7,4);
      boardMatrix[7][5] = new Bishop(true,7,5);
      boardMatrix[7][6] = new Knight(true,7,6);
      boardMatrix[7][7] = new Rook(true,7,7);
     
      bitboardMatrix = new Bitboard[2][6];
      
      bitboardMatrix[0][0] = whitePawns;
      bitboardMatrix[0][1] = whiteRooks;
      bitboardMatrix[0][2] = whiteKnights;
      bitboardMatrix[0][3] = whiteBishops;
      bitboardMatrix[0][4] = whiteQueens;
      bitboardMatrix[0][5] = whiteKing;
      bitboardMatrix[1][0] = blackPawns;
      bitboardMatrix[1][1] = blackRooks;
      bitboardMatrix[1][2] = blackKnights;
      bitboardMatrix[1][3] = blackBishops;
      bitboardMatrix[1][4] = blackQueens;
      bitboardMatrix[1][5] = blackKing;
      
    }

    public Piece[][] getBoardMatrix() {
        return boardMatrix;
    }
    public Piece getPieceFromSquare(int row, int col) {
        // System.out.println(row);
        // System.out.println(col);
        // System.out.println(boardMatrix[row][col].getColor());
     return boardMatrix[row][col]; 
    }
    
    public Bitboard getWhitePieces() {
      return whitePieces;
    }
    
    public Bitboard getBlackPieces() {
    return blackPieces; 
    }
    
    public Bitboard getAllPieces() {
    return allPieces;
    }

    public List<String> getMoves() {
      return moves;
    }

    public Hashtable<Integer, Character> getLetterCodes() {
      return letterCodes;
    }

    public Hashtable<Character, Integer> getFileCodes() {
      return fileCodes;
    }
    
    public void addMove(String uciString) {
        moves.add(uciString);
    }

    public void movePiece(boolean color, int startrow, int startcol, int endrow, int endcol) {
      // System.out.println(boardMatrix[endrow][endcol]);
      boardMatrix[endrow][endcol] = boardMatrix[startrow][startcol];
      boardMatrix[endrow][endcol].changeRow(endrow);
      boardMatrix[endrow][endcol].changeCol(endcol);
      boardMatrix[startrow][startcol] = null;
    }

    public static long[][] convertToBitboards(Piece[][] matrix) {
      long[][] bitboards = new long[2][6];
    
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          Piece piece = matrix[i][j];
          if (piece == null) {
            continue;
          }
          int index = piece.getColor() ? 0 : 1;
          long bitboard = 1L << (i * 8 + j);
          if (piece instanceof Pawn) {
            bitboards[index][0] |= bitboard;
          } else if (piece instanceof Knight) {
            bitboards[index][1] |= bitboard;
          } else if (piece instanceof Bishop) {
            bitboards[index][2] |= bitboard;
          } else if (piece instanceof Rook) {
            bitboards[index][3] |= bitboard;
          } else if (piece instanceof Queen) {
            bitboards[index][4] |= bitboard;
          } else if (piece instanceof King) {
            bitboards[index][5] |= bitboard;
          }
        }
      }
      return bitboards;
    }
    
    public void printBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(boardMatrix[x][y] != null) {
                    System.out.print(boardMatrix[x][y].getSymbol() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
    }
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
