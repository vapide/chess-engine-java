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
        newGame.uciToMove("e2e4");
        newGame.displayBoard();
        //System.out.println(board.getPieces());
    }

}
