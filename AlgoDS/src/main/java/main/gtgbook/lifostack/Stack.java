package main.gtgbook.lifostack;

public interface Stack<E> {

    /**
     * Counts elements in stack
     *
     * @return {int} number of elements
     */
    int size();

    /**
     * Checks if stack is empty
     *
     * @return {boolean} true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Add new element to stack to top of stack
     *
     * @param e {E} new element to add
     */
    void push(E e);

    /**
     * Peek at the top element without removing
     *
     * @return {E} element at top of stack
     */
    E top();

    /**
     * Removes element from top of stack
     *
     * @return {E} the element removed from top
     */
    E pop();
}
