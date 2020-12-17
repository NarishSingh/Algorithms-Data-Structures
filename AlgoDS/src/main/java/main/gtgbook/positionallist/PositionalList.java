package main.gtgbook.positionallist;

public interface PositionalList<E> {

    /**
     * Get the size of list
     *
     * @return {int} num of elements stored
     */
    int size();

    /**
     * Check if list is empty
     *
     * @return {boolean} true if no elements are stored, false otherwise
     */
    boolean isEmpty();

    /**
     * Get first Position in list
     *
     * @return {Position} first position, null if empty
     */
    Position<E> first();

    /**
     * Get last Position in list
     *
     * @return {Position} last position, null if empty
     */
    Position<E> last();

    /**
     * Retrieve the position immediately before p
     *
     * @param p {Position} starting position to search
     * @return {Position} the position before param
     * @throws IllegalArgumentException if p is first
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Retrieve the position immediately after p
     *
     * @param p {Position} starting position to search
     * @return {Position} the position after param
     * @throws IllegalArgumentException if p is last
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Insert element to the front of the list
     *
     * @param e {E} element to add
     * @return {E} successfully added element
     */
    Position<E> addFirst(E e);

    /**
     * Insert element to the back of the list
     *
     * @param e {E} element to add
     * @return {E} successfully added element
     */
    Position<E> addLast(E e);

    /**
     * Insert element immediately before position
     *
     * @param p {Position} where to add
     * @param e {E} new element to add
     * @return {E} the successfully insert element
     * @throws IllegalArgumentException if position is invalid
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Insert element immediately after position
     *
     * @param p {Position} where to add
     * @param e {E} new element to add
     * @return {E} the successfully insert element
     * @throws IllegalArgumentException if position is invalid
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replace an element at a given position
     *
     * @param p {Position} what element to replace
     * @param e {E} the new element to set at position
     * @return {E} the old element that was replaced
     * @throws IllegalArgumentException if position is invalid
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Remove an element at a given position
     *
     * @param p {Position} where to remove
     * @return {E} the successfully removed element, its position is now invalidated
     * @throws IllegalArgumentException if position is invalid
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
