/*
Treats array as circular by default to ensure
 */
package main.gtgbook.deque;

public class ArrayDeque<E> implements Deque<E> {

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
