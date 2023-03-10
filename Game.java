public class Game {
    private Chessboard boardClass;
    private Player player1;
    private Player player2;
    public Game(Chessboard board, Player p1, Player p2) {
        boardClass = board;
        player1 = p1;
        player2 = p2;
    }

    public int[] uciToInt(String uciString) {
        int[] moveVals = new int[4]; // startRow, startCol, endRow, endCol.
        if(uciString.length() == 5) { // change for promotion (im too lazy lol!)
            moveVals[0] = boardClass.getFileCodes().get(uciString.charAt(0));
            moveVals[1] = (int)uciString.charAt(1);
            moveVals[2] = boardClass.getFileCodes().get(uciString.charAt(2));
            moveVals[3] = (int)uciString.charAt(3);
        } else if(uciString.length() == 4) {
            moveVals[0] = boardClass.getFileCodes().get(uciString.charAt(0));
            moveVals[1] = (int)uciString.charAt(1);
            moveVals[2] = boardClass.getFileCodes().get(uciString.charAt(2));
            moveVals[3] = (int)uciString.charAt(3);
        }
        return moveVals;
    }
    public void movePiece(int startRow, int startCol, int endRow, int endCol) {
        
    }
    public void uciToMove(String uciString) {
     int[] moveVals = uciToInt(uciString);
     Piece myPieece = board.getPieceFromSquare(moveVals[0],moveVals[1]);
     if(myPiece.isValidMove(boardClass, myPiece.getColor(), moveVals[0],moveVals[1],moveVals[2],moveVals[3]))
    }

    // make method for ucitomove and use ucitoint or something
    // also make sure to check if it is a legal move you have board class get piece at position (might need to make it but its all there) and then just ask the piece if its a legal move
}
