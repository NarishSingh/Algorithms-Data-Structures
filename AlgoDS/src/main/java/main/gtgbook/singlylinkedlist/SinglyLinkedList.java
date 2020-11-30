/*
Generic singly linked list implementation
includes a Node nested class
 */
package main.gtgbook.singlylinkedlist;

public class SinglyLinkedList<E> implements Cloneable {

    /*Node nested class*/

    /**
     * Nodes for the list
     *
     * @param <E> generic type
     */
    private static class Node<E> {
        private E element;
        private Node<E> next; //pointer to next element

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    /*SLL class*/
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    //access methods

    /**
     * Get size of list
     *
     * @return {int} total count elements in list
     */
    public int size() {
        return size;
    }

    /**
     * Check if list is empty
     *
     * @return {boolean} true if size is 0, false if not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Read head node of list
     *
     * @return {E} first node
     */
    public E first() {
        return head.getElement();
    }

    /**
     * Read tail node of list
     *
     * @return {E} last node
     */
    public E last() {
        return tail.getElement();
    }

    //update methods

    /**
     * Add new node to head/front of list
     *
     * @param e {E} new node to add to beginning
     */
    public void addFirst(E e) {
        head = new Node<>(e, head); //simply create a new head and link to current head

        //if first addition, must also be considered tail
        if (size == 0) {
            tail = head;
        }

        size++;
    }

    /**
     * Add new node to tail/end of list
     *
     * @param e {E} new node to add to end
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); //nothing linked to tail

        if (isEmpty()) {
            head = newest; //if empty, newest node is head and tail
        } else {
            tail.setNext(newest); //otherwise, set link current tail to newest, which will be new tail
        }

        tail = newest; //newest node is now tail of list

        size++;
    }

    /**
     * Pop off head from front of list
     *
     * @return {E} removed head
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        //shift head to next element and decrement size
        E removed = head.getElement();
        head = head.getNext(); //note: if list will be emptied, this will become null
        size--;

        if (size == 0) {
            tail = null; //if list now empty, set the tail to null also
        }

        return removed;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //test for null
        if (o == null) {
            return false;
        }

        //test for type equivalence, if pass -> cast to SLL
        if (this.getClass() != o.getClass()) {
            return false;
        }

        SinglyLinkedList<?> other = (SinglyLinkedList<?>) o; //use of java wildcard to handle generic, suppresses unchecked cast warning

        //test for size equivalence
        if (this.size != other.size) {
            return false;
        }

        //walk along lists and test for equivalence
        Node<?> walkerA = head;
        Node<?> walkerB = other.head;

        while (walkerA != null) {
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
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); //creates a shallow copy

        //if not empty, we need a deep copy for true equivalence, walk through and copy
        if (size > 0) {
            other.head = new Node<>(this.head.getElement(), null);
            Node<E> walker = this.head.getNext(); //for traversing remainder of list
            Node<E> otherTail = other.head; //track most recently created node

            while (walker != null) {
                //create new node, link to clone's tail, then shift tail to newest node
                Node<E> newest = new Node<>(walker.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walker = walker.getNext();
            }
        }

        return other;
    }
}
