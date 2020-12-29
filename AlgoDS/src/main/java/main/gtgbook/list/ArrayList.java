package main.gtgbook.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Cloneable {

    /**
     * Iterator implementation - nonstatic so it can make reference to the containing list and access the array
     */
    private class ArrayIterator implements Iterator<E> {
        private int i = 0;
        private boolean removable = false;

        @Override
        public boolean hasNext() {
            return this.i < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (this.i == size) {
                throw new NoSuchElementException("At end of list");
            }

            this.removable = true;
            return data[this.i++]; //incr = iteration, next call is ready to return next element if not at end of list
        }

        @Override
        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("Nothing to remove");
            }

            ArrayList.this.remove(i - 1); //remove last one called
            this.i--; //shift to left
            this.removable = false; //don't remove again until next has been called
        }
    }

    /**
     * Iterator ctor
     *
     * @return {Iterator} for the arraylist
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /*ArrayList proper*/
    public static final int CAP = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAP);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
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
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, this.size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, this.size);
        E replaced = data[i];
        data[i] = e;
        return replaced;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, this.size + 1);

        //no resizing version
        /*
        if (this.size == data.length) {
            throw new IllegalStateException("Array is full");
        }
         */

        //dynamic resizing
        if (this.size == data.length) {
            this.resize(2 * data.length);
        }

        if (this.size - i >= 0) {
            System.arraycopy(data, i, data, i + 1, this.size - i);
        }

        data[i] = e;
        this.size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, this.size);
        E removed = data[i];
        if (this.size - 1 - i >= 0) {
            System.arraycopy(data, i + 1, data, i, this.size - 1 - i);
        }
        data[this.size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
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
        ArrayList<?> other = (ArrayList<?>) o;

        //size test
        if (this.size != other.size()) {
            return false;
        }

        //walk and test elements
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayList<E> clone() throws CloneNotSupportedException {
        //shallow copy
        ArrayList<E> clone = (ArrayList<E>) super.clone();

        //deep copy if not empty
        if (this.size() > 0) {
            for (int i = 0; i < this.size(); i++) {
                clone.set(i, this.get(i)); //set, because add will resize list and leave in the wrong data
            }
        }

        return clone;
    }

    /*HELPERS*/

    /**
     * Verifies parameterized index is in range
     *
     * @param i {int} index param
     * @param n {int} length of arraylist
     * @throws IndexOutOfBoundsException if index is out of range
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Resize arraylist to stop overflow
     *
     * @param capacity {int} new size for internal array
     */
    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        if (this.size >= 0) {
            System.arraycopy(data, 0, temp, 0, this.size);
        }
        this.data = temp;
    }

    /*Implementations of Collections intrf methods*/

    /**
     * Check of list contains parameterized obj
     *
     * @param o {Object} element to search for in list
     * @return {boolean} true if contains element, false otherwise. Will throw false if types don't match
     */
    public boolean contains(Object o) {
        //type check - since type is uniform, check against first of arraylist
        if (this.get(0).getClass() != o.getClass()) {
            return false;
        }

        //scan list
        //manual
        /*
        for (int i = 0; i < this.data.length; i++) {
            if (this.get(i) == o) {
                return true;
            }
        }
         */

        //iterator
        Iterator<E> lit = this.iterator();
        while (lit.hasNext()) {
            if (lit.next() == o) {
                return true;
            }
        }

        return false;
    }

    /**
     * Clear the arraylist
     */
    public void clear() {
        Iterator<E> lit = this.iterator();
        while (lit.hasNext()) {
            lit.next();
            lit.remove();
        }
    }
}
