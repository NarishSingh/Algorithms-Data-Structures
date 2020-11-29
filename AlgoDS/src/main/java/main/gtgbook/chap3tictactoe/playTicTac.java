package main.gtgbook.chap3tictactoe;

public class playTicTac {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe( );

        game.putMark(1,1); //X move
        game.putMark(0,2); //O move
        game.putMark(2,2); //X move
        game.putMark(0,0); //O move
        game.putMark(0,1); //X move
        game.putMark(2,1); //O move
        game.putMark(1,2); //X move
        game.putMark(1,0); //O move
        game.putMark(2,0); //X move
        System.out.println(game.toString());

        //pluck outcome string from arr
        int winningPlayer = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
        System.out.println(outcome[1 + winningPlayer]);
    }
}
