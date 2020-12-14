/*
This essentially implemented a doubly linked queue
 */
package main.gtgbook.doublylinkedlist;

public class DoublyLinkedList<E> implements Cloneable {

    /*Nested Node class - with pointers to both neighbors*/
    /**
     * Node for Doubly Linked List
     *
     * @param <E>
     */
    private static class Node<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /*Doubly Linked List*/
    private Node<E> header; //front of list sentinel
    private Node<E> trailer; //back of list sentinel
    private int size = 0;

    public DoublyLinkedList() {
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, header, null); // trailer preceded by header
        this.header.setNext(trailer); //header followed by trailer
    }

    //access
    /**
     * Get size of list
     *
     * @return {int} count of all elements
     */
    public int size() {
        return size;
    }

    /**
     * Check if list is empty
     *
     * @return {boolean} true if no elements but the sentinels are in list
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the element next to header/at front of list
     *
     * @return {E} first element
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }

        return header.getNext().getElement();
    }

    /**
     * Return the element before trailer/at end of list
     *
     * @return {E} last elements
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }

        return trailer.getPrev().getElement();
    }

    /**
     * Return the middle element, or left-middle if list is even
     * R3.8
     *
     * @return {E} middle element
     */
    public E middle() {
        if (isEmpty()) {
            return null;
        }

        //begin at header
        Node<E> middle = this.header;
        double i = Math.ceil((double) this.size / 2); //ceiling to deal w odds

        //iterate until at middle then retrieve element
        for (int j = 0; j < i; j++) {
            middle = middle.getNext();
        }

        return middle.getElement();
    }

    //update
    /**
     * Add to front of list
     *
     * @param e {E} new element to added
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Add to end of list
     *
     * @param e {E} new element to added
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Remove element from front of list
     *
     * @return {E} removed element
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        return remove(header.getNext());
    }

    /**
     * Remove element from end of list
     *
     * @return {E} removed element
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        return remove(trailer.getPrev());
    }


    //helpers
    /**
     * Adds a new node between 2 nodes of list
     *
     * @param e      {E} new node to add
     * @param before {Node} left neighbor for new addition
     * @param after  {Node} right neighbor for new addition
     */
    private void addBetween(E e, Node<E> before, Node<E> after) {
        Node<E> newest = new Node<>(e, before, after);
        before.setNext(newest);
        after.setPrev(newest);
        size++;
    }

    /**
     * Remove a node from list
     *
     * @param node {Node} node to be removed
     * @return {E} the removed element
     */
    private E remove(Node<E> node) {
        Node<E> before = node.getPrev();
        Node<E> after = node.getNext();

        //link the neighbors to one another and decr size, JVM garbage collection will delete
        before.setNext(after);
        after.setPrev(before);
        size--;

        return node.getElement();
    }

    @Override
    public boolean equals(Object o) {
        //test for null
        if (o == null) {
            return false;
        }

        //test for type
        if (this.getClass() != o.getClass()) {
            return false;
        }
        DoublyLinkedList<?> other = (DoublyLinkedList<?>) o;

        //test for size
        if (this.size != other.size) {
            return false;
        }

        //walk from first node ahead of header and test each, breaking on trailer
        Node<?> walkerA = this.header.getNext();
        Node<?> walkerB = other.header.getNext();

        while (walkerA != this.trailer) {
            if (!walkerA.getElement().equals(walkerB.getElement())) {
                return false;
            }

            walkerA = walkerA.getNext();
            walkerB = walkerB.getNext();
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public DoublyLinkedList<E> clone() throws CloneNotSupportedException {
        //make shallow copy
        DoublyLinkedList<E> clone = (DoublyLinkedList<E>) super.clone();

        //if not empty, make deep copy
        if (size > 0) {
            //create sentinels, walker and tracker
            clone.header = new Node<>(this.header.getElement(), null, this.trailer);
            clone.trailer = new Node<>(this.trailer.getElement(), this.header, null);
            Node<E> walker = this.header.getNext();
            Node<E> cloneTail = clone.header;

            //walk until trailer
            while (walker != this.trailer) {
                Node<E> newest = new Node<>(walker.getElement(), walker.getPrev(), null);
                cloneTail.setNext(newest);
                cloneTail = newest;
                walker = walker.getNext();
            }
        }

        return clone;
    }
}
