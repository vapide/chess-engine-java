public class Game {
    private Chessboard boardClass;
    private Player player1;
    private Player player2;
    public Game(Chessboard board, Player p1, Player p2) {
        boardClass = board;
        player1 = p1;
        player2 = p2;
    }

    public void displayBoard() {
        boardClass.displayBoard();
    }

    public int[] uciToInt(String uciString) {
        // System.out.println(uciString.charAt(1));
        int[] moveVals = new int[4]; // startRow, startCol, endRow, endCol.
        // Character srow = Character.getNumericValue(Character.valueOf(uciString.charAt(1)));
        // Character erow = Character.getNumericValue(Character.valueOf(uciString.charAt(3)));
        if(uciString.length() == 5) { // change for promotion (im too lazy lol!)
            moveVals[0] = boardClass.getFileCodes().get(uciString.charAt(0));
            moveVals[1] = 7 - (int)uciString.charAt(1) + 48;
            moveVals[2] = boardClass.getFileCodes().get(uciString.charAt(2));
            moveVals[3] = 7 - (int)uciString.charAt(3) + 48;
        } else if(uciString.length() == 4) {
            moveVals[0] = boardClass.getFileCodes().get(uciString.charAt(0));
            moveVals[1] = 7 - (int)uciString.charAt(1) + 48;
            moveVals[2] = boardClass.getFileCodes().get(uciString.charAt(2));
            moveVals[3] = 7 - (int)uciString.charAt(3) + 48;
        }
        // System.out.println(moveVals[1]);
        return moveVals;
    }

    public void uciToMove(String uciString) {
     int[] moveVals = uciToInt(uciString);
     // System.out.println(moveVals[1]);
     // System.out.println(moveVals[0]);
     Piece myPiece = boardClass.getPieceFromSquare(moveVals[1],moveVals[0]);
     // below 2 statements dont work getter methods return null what the freak.
     //System.out.println(myPiece.getColor());
     //System.out.println(myPiece.getRow());
     // System.out.println(MyPiece);
     // if(myPiece.isValidMove(boardClass, myPiece.getColor(), moveVals[1],moveVals[0],moveVals[3],moveVals[2])) {
      boardClass.movePiece(myPiece.getColor(), moveVals[1], moveVals[0], moveVals[3], moveVals[2]);   
     // }
    }

    // make method for ucitomove and use ucitoint or something
    // also make sure to check if it is a legal move you have board class get piece at position (might need to make it but its all there) and then just ask the piece if its a legal move
}
