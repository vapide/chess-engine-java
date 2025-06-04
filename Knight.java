public class Knight extends Piece {
    
    public Knight(boolean color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public char getSymbol() {
        return getColor() ? 'N' : 'n';
    }

    @Override    
    public Bitboard getLegalMoves(Chessboard board, int row, int col, boolean color) {
        int bitPos = row * 8 + col;
        long knight = 1L << bitPos;
        
        long notAFile = 0xfefefefefefefefeL;
        long notHFile = 0x7f7f7f7f7f7f7f7fL;
        long notABFiles = 0xfcfcfcfcfcfcfcfcL;
        long notGHFiles = 0x3f3f3f3f3f3f3f3fL;

        long northNorthEast = (knight << 17) & notAFile;
        long northEastEast = (knight << 10) & notABFiles;
        long northNorthWest = (knight << 15) & notHFile;
        long northWestWest = (knight << 6) & notGHFiles;
        long southSouthEast = (knight >>> 15) & notAFile;
        long southEastEast = (knight >>> 6) & notABFiles;
        long southSouthWest = (knight >>> 17) & notHFile;
        long southWestWest = (knight >>> 10) & notGHFiles;
        
        long moves = northNorthEast | northEastEast | northNorthWest | northWestWest |
                    southSouthEast | southEastEast | southSouthWest | southWestWest;
        
        long friendly = color ? board.getWhitePieces().getBitboard() : board.getBlackPieces().getBitboard();
        moves &= ~friendly;
        
        return new Bitboard(moves);
    }

    @Override
    public boolean isValidMove(Chessboard board, boolean color, int startrow, int startcol, int endrow, int endcol) {
        Bitboard legalMoves = getLegalMoves(board, startrow, startcol, color);
        
        int endBitPos = endrow * 8 + endcol;
        long endSquare = 1L << endBitPos;
        
        // Check if the destination square is in legal moves
        return (legalMoves.getBitboard() & endSquare) != 0;
    }
}
