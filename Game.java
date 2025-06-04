public class Game {
    private Chessboard boardClass;
    private Player player1;
    private Player player2;
    public Game(Chessboard board, Player p1, Player p2) {
        boardClass = board;
        player1 = p1;
        player2 = p2;
    }

    public void getMoves() {
        for(String move : boardClass.getMoves()) {
        System.out.print(move + " ");
        }
        System.out.println();
    }

    public Chessboard getBoard() {
        return boardClass;
    }
    
    public void displayBoard() {
        boardClass.printBoard();
        System.out.println();
        //boardClass.displayBoard();
    }

    public int[] uciToInt(String uciString) {
        //System.out.println(uciString.charAt(1));
        int[] moveVals = new int[4]; // startRow, startCol, endRow, endCol.
        // Character srow = Character.getNumericValue(Character.valueOf(uciString.charAt(1)));
        // Character erow = Character.getNumericValue(Character.valueOf(uciString.charAt(3)));
        // System.out.println(uciString.charAt(1) + '0');
        if(uciString.length() == 5) { // change for promotion (im too lazy lol!)
            moveVals[0] = boardClass.getFileCodes().get(uciString.charAt(0));
            moveVals[1] = (int)uciString.charAt(1) + 48;
            moveVals[2] = boardClass.getFileCodes().get(uciString.charAt(2));
            moveVals[3] = (int)uciString.charAt(3) + 48;
        } else if(uciString.length() == 4) { 
            moveVals[0] = boardClass.getFileCodes().get(uciString.charAt(0));  // file f -> 5
            moveVals[1] = 7 - ((int)(uciString.charAt(1) - '0')-1); 
            moveVals[2] = boardClass.getFileCodes().get(uciString.charAt(2));  // file g -> 6
            moveVals[3] = 7 - ((int)(uciString.charAt(3) - '0')-1);
        }
        // System.out.println(moveVals[1]);
        return moveVals;
    }

    public void uciToMove(String uciString) {     
     int[] moveVals = uciToInt(uciString);
     System.out.println("Start row: " + moveVals[1]); // should be 2 for rank 3
     System.out.println("Start col: " + moveVals[0]); // should be 5 for file f
     System.out.println("End row: " + moveVals[3]);   // should be 4 for rank 5
     System.out.println("End col: " + moveVals[2]);   // should be 6 for file g
     Piece myPiece = boardClass.getPieceFromSquare(moveVals[1],moveVals[0]);
     if (myPiece == null) {
         System.out.println("No piece at source square for move: " + uciString);
         return;
     }
     boolean valid = myPiece.isValidMove(boardClass, myPiece.getColor(), moveVals[1], moveVals[0], moveVals[3], moveVals[2]);
     /*
        if(myPiece.isValidMove) {
            ...
            to update bitboards i would do something like have a function that determines distance or directions or steps in order to move the piece i have utility methods in the bitboard class so add that **
        } else {
            throw error
        }
     */
     // below 2 statements dont work getter methods return null what the freak.
     // System.out.println(myPiece.getColor());
     // System.out.println(myPiece.getRow());
     // System.out.println(MyPiece);
     // if(myPiece.isValidMove(boardClass, myPiece.getColor(), moveVals[1],moveVals[0],moveVals[3],moveVals[2])) {
        if(valid) {
      boardClass.addMove(uciString);
      boardClass.movePiece(myPiece.getColor(), moveVals[1], moveVals[0], moveVals[3], moveVals[2]);   
        } else {
            System.out.println("Invalid move: " + uciString);
        }
     // }
    }

    // make method for ucitomove and use ucitoint or something
    // also make sure to check if it is a legal move you have board class get piece at position (might need to make it but its all there) and then just ask the piece if its a legal move
}
