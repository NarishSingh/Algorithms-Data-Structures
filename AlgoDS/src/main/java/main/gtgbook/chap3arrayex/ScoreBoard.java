package main.gtgbook.chap3arrayex;

import java.util.Arrays;

public class ScoreBoard {

    private int numEntries = 0;
    private GameEntry[] board;

    /*custom ctor*/
    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    /*methods*/

    /**
     * Add a new game entry, sorting list first to make space for new high score
     *
     * @param e {GameEntry} a high score if array is full, or a score if space is available
     */
    public void add(GameEntry e) {
        int newScore = e.getScore();

        //check if new score is a high score, or if board has open slots
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }

            //shift higher scores to right of new entry
            //lowest score gets pushed out this way
            int j = numEntries - 1; //start from end of array, which will have highest score thus far
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }

            board[j] = e; //when shifting is complete, add new entry
        }
    }

    /**
     * Remove a high score and sort array
     *
     * @param i {int} index to remove
     * @return {GameEntry} the removed element
     * @throws IndexOutOfBoundsException if i is greater or less than board bounds
     */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }

        GameEntry removed = board[i];

        //starting at the index from param, shift the element to end of array
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }

        //kill last entry and return removed
        board[numEntries - 1] = null;
        numEntries--;

        return removed;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "numEntries=" + numEntries +
                ", board=" + Arrays.toString(board) +
                '}';
    }
}
