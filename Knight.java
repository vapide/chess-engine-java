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
    @Override
    public Bitboard getLegalMoves(Chessboard board, int row, int col, boolean color) {
        // int bitPos = row * 8 + col;
        long moves = ((row <= 5 && col <= 6 ? 1L << ((row + 2) * 8 + (col + 1)) : 0L) | (row <= 6 && col <= 5 ? 1L << ((row + 1) * 8 + (col + 2)) : 0L) | (row >= 1 && col <= 5 ? 1L << ((row - 1) * 8 + (col + 2)) : 0L) | (row >= 2 && col <= 6 ? 1L << ((row - 2) * 8 + (col + 1)) : 0L) | (row >= 2 && col >= 1 ? 1L << ((row - 2) * 8 + (col - 1)) : 0L) | (row >= 1 && col >= 2 ? 1L << ((row - 1) * 8 + (col - 2)) : 0L) | (row <= 6 && col >= 2 ? 1L << ((row + 1) * 8 + (col - 2)) : 0L) | (row <= 5 && col >= 1 ? 1L << ((row + 2) * 8 + (col - 1)) : 0L));
        long friendly = color ? board.getWhitePieces().getBitboard() : board.getBlackPieces().getBitboard();
        moves &= ~friendly;
        return new Bitboard(moves);
    }

    @Override
    public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
        Bitboard legalMoves = getLegalMoves(board, startrow, startcol, color);
        int endBitPos = endrow * 8 + endcol;
        long endSquare = 1L << endBitPos;
        Bitboard pieces = color ? board.getWhitePieces() : board.getBlackPieces();
        int startBitPos = startrow * 8 + startcol;
        long startSquare = 1L << startBitPos;
        return (pieces.getBitboard() & startSquare) != 0
            && (legalMoves.getBitboard() & endSquare) != 0;
    }
}
