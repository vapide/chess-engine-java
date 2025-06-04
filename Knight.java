public class Knight extends Piece {
    
    public Knight(boolean color, int row, int col) {
        super(color, row, col);
        //bitboard = new Bitboard( 1L << (row * 8 + col));
    }

    @Override
    public char getSymbol() {
        return getColor() ? 'N' : 'n';
    }

    public int getSize(int n) {
        return 2 * ((n * n) & (n < 2 ? 1 : 0)); 
    }

    public int getDiff(int n) {
        return (n - 2) & (n >= 3 ? -1 : 0); 
    }

    public long repeat(int number) { 
        return (number & 0xFFL) * 0x0101010101010101L;
    }

    public int fillCol(int n) {
        return (255 >> (8 - n)) & 255; // fills 0b00000000 with 1s starting from left to right
    }
    
    @Override    public Bitboard getLegalMoves(Chessboard board, int row, int col, boolean color) {
        int bitPos = (7 - row) * 8 + col;  // Flip row for bitboard representation
        long knight = 1L << bitPos;

        // File masks to prevent wrapping around
        long notA = 0xfefefefefefefefeL;
        long notAB = 0xfcfcfcfcfcfcfcfcL;
        long notH = 0x7f7f7f7f7f7f7f7fL;
        long notGH = 0x3f3f3f3f3f3f3f3fL;

        long moves = ((knight << 17) & notA) | ((knight << 15) & notH) | ((knight << 10) & notAB) | ((knight << 6) & notGH) | ((knight >>> 17) & notH) | ((knight >>> 15) & notA) | ((knight >>> 10) & notGH) | ((knight >>> 6) & notAB);
        //Bitboard.printBitboard(board.getWhitePieces());
        long friendly = color ? board.getWhitePieces().getBitboard() : board.getBlackPieces().getBitboard();
        moves &= ~friendly;
        return new Bitboard(moves);
    }

    @Override
    public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
        Bitboard legalMoves = getLegalMoves(board, startrow, startcol, color);
        int endBitPos = (7 - endrow) * 8 + endcol;
        long endSquare = 1L << endBitPos;
        Bitboard pieces = color ? board.getWhitePieces() : board.getBlackPieces();
        int startBitPos = (7 - startrow) * 8 + startcol;
        long startSquare = 1L << startBitPos;
        return (pieces.getBitboard() & startSquare) != 0
            && (legalMoves.getBitboard() & endSquare) != 0;
    }
}
