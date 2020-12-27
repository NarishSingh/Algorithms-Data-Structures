/*
Treats array as circular by default to ensure
 */
package main.gtgbook.deque;

import java.util.Arrays;

public class ArrayDeque<E> implements Deque<E>, Cloneable {

    private E[] data;
    private int f = 0; //front of array
    private int sz = 0; //size
    private static final int CAP = 1000;

    public ArrayDeque() {
        this(CAP);
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int cap) {
        data = (E[]) new Object[cap];
    }

    @Override
    public int size() {
        return this.sz;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }

        return data[f];
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }

        int tail = (f - 1 + sz) % data.length; //should be before next available index
        return data[tail];
    }

    @Override
    public void addFirst(E e) throws IllegalStateException {
        if (this.sz == data.length) {
            throw new IllegalStateException("Deque is full");
        }

        //decrement f circularly, then assign
        f = (f - 1 + data.length) % data.length; //ensures the front is decremented without becoming negative
        data[f] = e;
        this.sz++;
    }

    @Override
    public void addLast(E e) throws IllegalStateException {
        if (this.sz == data.length) {
            throw new IllegalStateException("Deque is full");
        }

        //check availability and assign
        int avail = (f + sz) % data.length;
        data[avail] = e;
        this.sz++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E removed = data[f];
        data[f] = null;
        f = (f + 1) % data.length; //computes next opening
        this.sz--;
        return removed;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        int tail = (f - 1 + sz) % data.length;
        E removed = data[tail];
        data[tail] = null;
        this.sz--;
        return removed;
    }

    @Override
    public boolean equals(Object o) {
        //null test
        if (o == null) {
            return false;
        }

        //type test and cast
        if (o.getClass() != this.getClass()) {
            return false;
        }
        ArrayDeque<?> other = (ArrayDeque<?>) o;

        //size test
        if (other.size() != this.size()) {
            return false;
        }

        //element test
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i] != other.data[i]) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayDeque<E> clone() throws CloneNotSupportedException {
        ArrayDeque<E> clone = (ArrayDeque<E>) super.clone();

        if (this.size()>0){
            System.arraycopy(this.data, 0, clone.data, 0, this.size());
        }

        return clone;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "data=" + Arrays.toString(data) +
                ", f=" + f +
                ", sz=" + sz +
                '}';
    }

    /*helper*/
    /**
     * Check size of array deque
     *
     * @return {boolean} true if size is 0, false otherwise
     */
    private boolean isEmpty() {
        return this.sz == 0;
    }
}
