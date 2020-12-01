/*
SLL but the tail is set to refer back to the head, along navigation back to beginning
 */
package main.gtgbook.circularlinkedlist;

public class CircularLinkedList<E> {

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

        //toString causes infinite recursion leading to stack overflow error
    }

    /*Circular linked list class*/
    private Node<E> tail = null;
    private int size = 0;

    public CircularLinkedList() {
    }

    //access

    /**
     * Get size of list
     *
     * @return {int} total count of elements in list
     */
    public int size() {
        return size;
    }

    /**
     * Check if list is empty
     *
     * @return {boolean} true if size is 0, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Read first element, or "head" of list
     *
     * @return {E} first node of list
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }

        return tail.getNext().getElement(); //since its circular, no need to track head
    }

    /**
     * Return tail/last element of list
     *
     * @return {E} last node of list
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }

        return tail.getElement();
    }

    //update

    /**
     * Move first element to the back of the list
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    /**
     * Add new node to the front of the list
     *
     * @param e {E} new node to become the new "head"
     */
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null); //if list was empty, new node will be only elem
            this.tail.setNext(tail); //link to itself circularly
        } else {
            //link tail to newly created node, since circuarly connected
            tail.setNext(new Node<>(e, tail.getNext()));

            //revision from R3.7
//            Node<E> newest = new Node<>(e, tail.getNext());
//            tail.setNext(newest);
        }

        size++;
    }

    /**
     * Add new node to the tail/end of the list
     *
     * @param e {E} new tail node
     */
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    /**
     * Remove "head" element from front of the list
     *
     * @return
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> head = tail.getNext();

        if (head == tail) {
            tail = null; //if size == 1
        } else {
            tail.setNext(head.getNext()); //remove head and link tail to next elem past the removed
        }

        size--;

        return head.getElement();
    }
}
