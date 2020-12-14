package main.gtgbook.list;

public interface List<E> {

    /**
     * Get size of list
     *
     * @return {int} number of elements in list
     */
    int size();

    /**
     * Check if list is empty
     *
     * @return {boolean} true if no elements in list, false otherwise
     */
    boolean isEmpty();

    /**
     * Read an element from list
     *
     * @param i {int} index
     * @return {E} element at index
     * @throws IndexOutOfBoundsException if i>list.size()
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replace the element at the index
     *
     * @param i {int} index
     * @param e {E} element to set
     * @return {E} the replaced element
     * @throws IndexOutOfBoundsException if i>list.size()
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Insert new element to index and shift elements ahead
     *
     * @param i {int} index
     * @param e {E} element to insert
     * @throws IndexOutOfBoundsException if i>list.size()
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Remove an element and shift elements down
     *
     * @param i {int} index
     * @return {E} the removed element
     * @throws IndexOutOfBoundsException if i>list.size()
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
