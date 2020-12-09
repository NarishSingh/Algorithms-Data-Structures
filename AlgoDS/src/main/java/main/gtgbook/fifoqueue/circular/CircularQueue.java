package main.gtgbook.fifoqueue.circular;

import main.gtgbook.fifoqueue.Queue;

public interface CircularQueue<E> extends Queue<E> {

    /**
     * Moves front of queue to back
     */
    void rotate();
}
