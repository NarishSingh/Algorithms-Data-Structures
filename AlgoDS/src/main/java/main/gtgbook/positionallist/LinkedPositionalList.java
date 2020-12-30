package main.gtgbook.positionallist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Cloneable {

    /*Nested Node class*/
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (this.next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return this.element;
        }

        public void setElement(E element) {
            this.element = element;
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

    /*Nested PositionIterator class - core for list iteration*/
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); //position of next element to report
        private Position<E> recent = null; //position of last reported element

        @Override
        public boolean hasNext() {
            return this.cursor != null; //test is has next obj to itr
        }

        @Override
        public Position<E> next() throws NoSuchElementException {
            if (this.cursor == null) {
                throw new NoSuchElementException("At end of list");
            }

            //return next, move cursor forward
            this.recent = this.cursor;
            this.cursor = after(cursor);
            return this.recent;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (this.recent == null) {
                throw new IllegalStateException("Nothing to remove");
            }

            LinkedPositionalList.this.remove(this.recent);
            this.recent = null;
        }
    }

    /*Nested PositionIterable class - for iterating through positions*/
    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    /**
     * Returns an iterable representation of list's positions
     *
     * @return {PositionIterable} new instance of inner class
     */
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    /*Nested ElementIterator class - for iterating through elements*/
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posItr = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posItr.hasNext();
        }

        @Override
        public E next() {
            return posItr.next().getElement();
        }

        @Override
        public void remove() {
            posItr.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /*Linked Positional List proper*/
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, this.header, null);
        header.setNext(this.trailer);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Position<E> first() {
        return position(this.header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(this.trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, this.header, this.header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, this.trailer.getPrev(), this.trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        //link neighbor nodes to each other
        Node<E> before = node.getPrev();
        Node<E> after = node.getNext();
        before.setNext(after);
        after.setPrev(before);
        this.size--;

        //scrub the node clean so it can no longer be called
        E removed = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);

        return removed;
    }

    @Override
    public boolean equals(Object o) {
        //null test
        if (o == null) {
            return false;
        }

        //type test and cast
        if (this.getClass() != o.getClass()) {
            return false;
        }
        LinkedPositionalList<?> other = (LinkedPositionalList<?>) o;

        //size test
        if (this.size() != other.size()) {
            return false;
        }

        //walk and element test
        Node<?> walkerA = this.header;
        Node<?> walkerB = other.header;

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
    protected LinkedPositionalList<E> clone() throws CloneNotSupportedException {
        LinkedPositionalList<E> clone = (LinkedPositionalList<E>) super.clone();

        if (this.size() > 0) {
            //FIXME not working
            //create header and trailer nodes and link up
            clone.header = new Node<>(this.header.getElement(), null, null);
            clone.trailer = new Node<>(this.trailer.getElement(), clone.header, null);
            clone.header.setNext(clone.trailer);

            //a walker and tracker
            Node<E> walker = this.header.getNext();
            Node<E> cloneTrailer = clone.header;

            //walk, creating new nodes and linking to trailer
            while (walker != null) {
                Node<E> newest = new Node<>(walker.getElement(), cloneTrailer, null);
                cloneTrailer.setNext(newest);
                cloneTrailer = newest;
                walker = walker.getNext();
            }
        }

        return clone;
    }

    /*Helpers*/

    /**
     * Validate the position and return its node - this ensures Node class is encapsulated behind a Position
     *
     * @param p {Position} a position
     * @return {Node} the Node associated with that position
     * @throws IllegalArgumentException if position is invalid or no longer active in list
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid");
        }

        Node<E> node = (Node<E>) p;

        //check if node is defunct
        if (node.getNext() == null) {
            throw new IllegalArgumentException("P is no longer in list");
        }

        return node;
    }

    /**
     * Returns node as position if not a sentinel
     *
     * @param node {Node} node to verify
     * @return {Position} node as position, null if a sentinel
     */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null; //don't expose the sentinels to the user
        }
        return node;
    }

    /**
     * Insert a new node to list
     *
     * @param e      {E} new element to add
     * @param before {Node} the previous node
     * @param after  {Node} the next node
     * @return {Position} the position of the successfully added node
     */
    private Position<E> addBetween(E e, Node<E> before, Node<E> after) {
        Node<E> newest = new Node<>(e, before, after);
        before.setNext(newest);
        after.setPrev(newest);
        this.size++;
        return newest;
    }
}
