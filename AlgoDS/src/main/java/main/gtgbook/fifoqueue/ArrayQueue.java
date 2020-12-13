/*
To solve the problem of removing elements from the front, we use the array circularly -> this way the reference to the front never exceeds length
 */
package main.gtgbook.fifoqueue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E>, Cloneable {

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

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + Arrays.toString(data) +
                ", f=" + f +
                ", sz=" + sz +
                '}';
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayQueue<E> clone() throws CloneNotSupportedException {
        //create shallow copy
        ArrayQueue<E> other = (ArrayQueue<E>) super.clone();

        if (this.size() > 0) {
            System.arraycopy(this.data, 0, other.data, 0, this.size());
        }

        return other;
    }

    @Override
    public boolean equals(Object o) {
        //null test
        if (o == null) {
            return false;
        }

        //type test, if pass -> cast
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>) o;

        //size test
        if (this.size() != other.size()) {
            return false;
        }

        //walk and element test
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i] != other.data[i]) {
                return false;
            }
        }

        return true;
    }
}
