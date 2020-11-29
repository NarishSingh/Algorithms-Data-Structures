/*
TicTacToe game, no ai or play just the algorithms
 */
package main.gtgbook.chap3tictactoe;

public class TicTacToe {

    public static final int X = 1; //player
    public static final int O = -1; //opponent
    public static final int EMPTY = 0; //open cell
    private int board[][] = new int[3][3]; //game board
    private int player;

    /**
     * ctor, just clears the board for new play
     */
    public TicTacToe() {
        clearBoard();
    }

    /**
     * Clear the board
     */
    private void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }

        player = X;
    }

    /**
     * Place a mark on the board
     *
     * @param i {int} row
     * @param j {int} column
     * @throws IllegalArgumentException if illegal move attempted
     */
    public void putMark(int i, int j) throws IllegalArgumentException {
        if (i < 0 || i > 2 || j < 0 || j > 2) {
            throw new IllegalArgumentException("Invalid position");
        } else if (board[i][j] != EMPTY) {
            throw new IllegalArgumentException("Position occupied");
        } else {
            board[i][j] = player;
            player = -player; //switch player by inverting value
        }
    }

    /**
     * Check if a game is won for a player
     *
     * @param mark {int} the mark for a player, 1 = X, -1 = O
     * @return {boolean} win or loss based on board
     */
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) // row 0
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3) // row 1
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3) // row 2
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3) // column 0
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3) // column 1
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3) // column 2
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3) // diagonal
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // rev diag
    }

    /**
     * Determine the winner of the game
     *
     * @return {int} the winner, or 0 for tie
     */
    public int winner() {
        if (isWin(X)) {
            return X;
        } else if (isWin(O)) {
            return O;
        } else {
            return 0;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X: {
                        sb.append("X");
                        break;
                    }
                    case O: {
                        sb.append("O");
                        break;
                    }
                    case EMPTY: {
                        sb.append(" ");
                        break;
                    }
                }

                if (j < 2) {
                    sb.append("|"); //col boundary
                }
            }

            if (i < 2) {
                sb.append("\n------\n"); //row boundary
            }
        }

        return sb.toString();
    }
}
