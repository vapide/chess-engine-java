/*
Bitboard

This class is used to represent a chess board.

Fields

FILE_A
: a bitboard representing the first file (column) of the chess board
FILE_H
: a bitboard representing the last file (column) of the chess board
RANK_1
: a bitboard representing the first rank (row) of the chess board
RANK_2
: a bitboard representing the second rank (row) of the chess board
RANK_7
: a bitboard representing the seventh rank (row) of the chess board
RANK_8
: a bitboard representing the eighth rank (row) of the chess board
bitboard
: a bitboard representing the chess board
Methods

Bitboard(long bb)
: constructor for the class
getBitboard()
: returns the bitboard representing the chess board
northOne(long bb)
: returns a bitboard representing the board at the next rank
southOne(long bb)
: returns a bitboard representing the board at the previous rank
eastOne(long bb)
: returns a bitboard representing the board at the next file
westOne(long bb)
: returns a bitboard representing the board at the previous file
northEastOne(long bb)
: returns a bitboard representing the board at the next rank and next file
northWestOne(long bb)
: returns a bitboard representing the board at the next rank and previous file
southEastOne(long bb)
: returns a bitboard representing the board at the previous rank and next file
southWestOne(long bb)
: returns a bitboard representing the board at the previous rank and previous file
rotateBitmap(long bb)
: returns a bitboard representing the board after rotating it clockwise 45 degrees
 */
public class Bitboard {
  // Set a bit at the given position
  public void setBit(int pos) {
    bitboard |= (1L << pos);
  }

  // Clear a bit at the given position
  public void clearBit(int pos) {
    bitboard &= ~(1L << pos);
  }

  // Predefined bitboards for files and ranks
  public static final long DIAG_AH = -9205322385119247871L; // 0b1000000001000000001000000001000000001000000001000000001000000001 
  public static final long DIAG_HA = 72624976668147840L; // 0b0000000100000010000001000000100000010000001000000100000010000000
  public static final long FILE_A = -9187201950435737472L; // 0x8080808080808080L
  public static final long FILE_H = 72340172838076673L; // 0x101010101010101L
  public static final long RANK_1 = 255L; // 0x00000000000000FFL
  public static final long RANK_2 = 65280L; // 0x000000000000FF00L
  public static final long RANK_7 = 71776119061217280L; // 0xFF00000000000000L
  public static final long RANK_8 = -72057594037927936L; // 0x00FF000000000000L

  // The bitboard itself
  public long bitboard; // bitboard

  // Constructor that takes a long and initializes the bitboard
  public Bitboard(long bb) {
    bitboard = bb;
  }

  // Getter for the bitboard
  public long getBitboard() {
    return bitboard;
  }

  // Utility methods for moving pieces on the bitboard

  // Shifts the bits of the bitboard one square to the north
  public static long northOne(long bb) {
    return bb << 8;
  }

  // Shifts the bits of the bitboard one square to the south
  public static long southOne(long bb) {
    return bb >>> 8;
  }

  // Shifts the bits of the bitboard one square to the east
  // and clears the bits that wrap around to the A file
  public static long eastOne(long bb) {
    return (bb << 1) & ~FILE_A;
  }

  // Shifts the bits of the bitboard one square to the west
  // and clears the bits that wrap around to the H file
  public static long westOne(long bb) {
    return (bb >>> 1) & ~FILE_H;
  }

  // Shifts the bits of the bitboard one square to the northeast
  // and clears the bits that wrap around to the A file
  public static long northEastOne(long bb) {
    return (bb << 9) & ~FILE_A;
  }

  // Shifts the bits of the bitboard one square to the northwest
  // and clears the bits that wrap around to the H file
  public static long northWestOne(long bb) {
    return (bb << 7) & ~FILE_H;
  }

  // Shifts the bits of the bitboard one square to the southeast
  // and clears the bits that wrap around to the A file
  public static long southEastOne(long bb) {
    return (bb >>> 7) & ~FILE_A;
  }

  // Shifts the bits of the bitboard one square to the southwest
  // and clears the bits that wrap around to the H file
  public static long southWestOne(long bb) {
    return (bb >>> 9) & ~FILE_H;
  }

public static void printBitboard(Bitboard bitboard) {
    // Print from rank 8 to rank 1 (top to bottom), matching chess notation
    for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
            // Match the same bit calculation as used in Knight.java
            long bit = bitboard.getBitboard() & (1L << ((7 - row) * 8 + col));
            System.out.print((bit != 0) ? "1 " : "0 ");
        }
        System.out.println();
    }
}

  public static long rotateBitmap(long bb) {
    // Create a 2D matrix representation of the bitboard
    int[][] matrix = new int[8][8];
    for (int i = 0; i < 64; i++) {
      int row = i / 8;
      int col = i % 8;
      // Extract the bit at position i from the bitboard
      matrix[row][col] = (int) ((bb >> (63 - i)) & 1);
    }

    // Define the rotation matrix for 45 degrees clockwise rotation
    double[][] rotationMatrix = {
      { 1 / Math.sqrt(2), -1 / Math.sqrt(2) },
      { 1 / Math.sqrt(2), 1 / Math.sqrt(2) },
    };

    // Apply the rotation matrix to the matrix representation of the bitboard
    int[][] rotatedMatrix = new int[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        double sum = 0;
        // Compute the dot product of the i-th row of the matrix and the first column of the rotation matrix
        sum += rotationMatrix[0][0] * matrix[i][j];
        sum += rotationMatrix[1][0] * matrix[i][(j + 1) % 8];
        // Compute the dot product of the i-th row of the matrix and the second column of the rotation matrix
        sum += rotationMatrix[0][1] * matrix[i][j];
        sum += rotationMatrix[1][1] * matrix[i][(j + 1) % 8];
        // Round the result to the nearest integer
        rotatedMatrix[i][j] = (int) Math.round(sum);
      }
    }

    // Convert the rotated matrix back to a bitboard
    long rotatedBitboard = 0;
    for (int i = 0; i < 64; i++) {
      int row = i / 8;
      int col = i % 8;
      // Set the bit at position i in the bitboard to the corresponding value in the rotated matrix
      rotatedBitboard |= ((long) rotatedMatrix[row][col] & 1) << (63 - i);
    }

    // Return the rotated bitboard
    return rotatedBitboard;
  }
}
