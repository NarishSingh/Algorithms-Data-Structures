package main.gtgbook.fifoqueue;

public interface Queue<E> {

    /**
     * Check size of queue
     *
     * @return {int} number of elements
     */
    int size();

    /**
     * Check if queue is empty
     *
     * @return {boolean} true if no elements, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts new element to back of queue
     *
     * @param e {E} element added to back
     */
    void enqueue(E e);

    /**
     * Peeks at first element in queue
     *
     * @return {E} first element
     */
    E first();

    /**
     * Remove the first element from queue
     *
     * @return {E} the removed element from front
     */
    E dequeue();
}
