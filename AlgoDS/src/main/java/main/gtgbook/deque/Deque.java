/*
Double ended deque - allows elements to be inserted from front or back
 */
package main.gtgbook.deque;

public interface Deque<E> {

    /**
     * Count elements in deque
     *
     * @return {int} current size
     */
    int size();

    /**
     * Retrieve first element in deque
     *
     * @return {E} first element
     */
    E first();

    /**
     * Retrieve last element in deque
     *
     * @return {E} last element
     */
    E last();

    /**
     * Insert new element to front of deque
     *
     * @param e {E} newly added element
     */
    void addFirst(E e);

    /**
     * Insert new element to back of deque
     *
     * @param e {E} newly added element
     */
    void addLast(E e);

    /**
     * Remove an element from front of deque
     *
     * @return {E} the removed element
     */
    E removeFirst();

    /**
     * Remove an element from back of deque
     *
     * @return {E} removed element
     */
    E removeLast();
}
