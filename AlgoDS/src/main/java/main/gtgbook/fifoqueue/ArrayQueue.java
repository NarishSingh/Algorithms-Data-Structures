/*
To solve the problem of removing elements from the front, we use the array circularly -> this way the reference to the front never exceeds length
 */
package main.gtgbook.fifoqueue;

public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int f = 0; //ref to front
    private int sz = 0; //size of arrayqueue
    private static final int CAPACITY = 1000; //array max

    public ArrayQueue() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return this.sz;
    }

    @Override
    public boolean isEmpty() {
        return this.sz == 0;
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (this.sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        int avail = (this.f + this.sz) % data.length; //check available index with modulo
        data[avail] = e;
        this.sz++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }

        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        //retrieve front then set to null, move front ref circularly then decrement size
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length; //computes next opening
        sz--;
        return answer;
    }
}
