public class Main {

    public static void main(String[] args) {
        //Pawn pp = new Pawn(true,1,0);
        //System.out.println(pp.getColor()); works here though???
        Chessboard board = new Chessboard();
        //board.displayBoard();
        Player player1 = new Player("White", true);
        Player player2 = new Player("Black", false);
        Game newGame = new Game(board, player1, player2);
        newGame.displayBoard();
        newGame.uciToMove("g1f4");
        Bitboard.printBitboard((newGame.getBoard().getPieceFromSquare(0, 6).getLegalMoves(newGame.getBoard(), 0, 6, true)));
        newGame.displayBoard();
        newGame.getMoves();
        newGame.uciToMove("g1f3");
        newGame.displayBoard();
        newGame.getMoves();
        newGame.uciToMove("g8f6");
        newGame.displayBoard();
        newGame.getMoves();
        //System.out.println(board.getPieces());
    }

}
