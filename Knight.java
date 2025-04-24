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
        if (this.pieceColor) {
            return 'N';
        } else {
            return 'n';
        }
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

    public Bitboard getLegalMoves(Chessboard board, int row, int col, boolean color) {
        int bitPos = (7 - row) * 8 + col;
                long mask = 0b10100001000100000000000100010000101L << bitPos;
        
                long potentialMoves = mask & ~(color ? board.getWhitePieces().getBitboard() : board.getBlackPieces().getBitboard());

        return new Bitboard(potentialMoves);
    }

    @Override
    public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
        
        int startBitPos = (7 - startrow) * 8 + startcol;
        int endBitPos = (7 - endrow) * 8 + endcol;

        long startSquare = 1L << startBitPos;
        long endSquare = 1L << endBitPos;

        Bitboard pieces = color ? board.getWhitePieces() : board.getBlackPieces();
        return (pieces.getBitboard() & startSquare) != 0 
            && (getLegalMoves(board, startrow, startcol, color).getBitboard() & endSquare) != 0;
    }
}
