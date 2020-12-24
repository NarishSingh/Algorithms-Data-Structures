/*
R7.2 - Stack ADT with an ArrayList data store
 */
package main.gtgbook.lifostack;

import main.gtgbook.list.ArrayList;
import main.gtgbook.list.List;

public class ArrayListStack<E> implements Stack<E>, Cloneable {

    public static final int CAPACITY = 16;
    private List<E> data;
    private int t = -1; //track top of the list

    public ArrayListStack() {
        this(CAPACITY);
    }

    public ArrayListStack(int cap) {
        this.data = new ArrayList<>(cap);
    }

    @Override
    public int size() {
        return this.t + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.t == -1;
    }

    @Override
    public void push(E e) {
        this.data.add(++t, e); //add handles resizing if needed
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }

        return this.data.get(t);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        return this.data.remove(t--);
    }

    @Override
    public boolean equals(Object o) {
        //null test
        if (o == null) {
            return false;
        }

        //type eq test and cast
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayListStack<?> other = (ArrayListStack<?>) o;

        //size test
        if (this.size() != other.size()) {
            return false;
        }

        //can use ArrayList equals implementation to test element equivalence
        if (!this.data.equals(other.data)) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayListStack<E> clone() throws CloneNotSupportedException {
        //create shallow copy
        ArrayListStack<E> clone = (ArrayListStack<E>) super.clone();

        //make deep copy if not empty
        if (this.size() > 0) {
            for (int i = 0; i < this.data.size(); i++) {
                clone.data.set(i, this.data.get(i));
            }
        }

        return clone;
    }

    @Override
    public String toString() {
        return "ArrayListStack{" +
                "data=" + data +
                ", t=" + t +
                '}';
    }
}
