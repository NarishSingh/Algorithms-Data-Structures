/*
Array based implementation of stack
good for use cases where amount of data needed is known
 */
package main.gtgbook.lifostack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>, Cloneable {

    public static final int CAPACITY = 1000; //default arr cap
    private E[] data;
    private int t = -1; //index of top element, such that size = t+1

    public ArrayStack() {
        this(CAPACITY); //create max stack
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
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
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }

        this.data[++t] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }

        return this.data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E removed = data[t];
        data[t] = null;
        t--;

        return removed;
    }

    @Override
    public boolean equals(Object o) {
        //null test
        if (o == null) {
            return false;
        }

        //type equivalence test, if passed cast to array stack
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayStack<?> other = (ArrayStack<?>) o;

        //test for size equivalence
        if (this.size() != other.size()) {
            return false;
        }

        //walk stack and test element equivalence
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i] != other.data[i]) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayStack<E> clone() throws CloneNotSupportedException {
        //create shallow copy
        ArrayStack<E> other = (ArrayStack<E>) super.clone();

        //if populated, need deep copy
        if (this.size() > 0) {
            if (this.size() >= 0) {
                System.arraycopy(this.data, 0, other.data, 0, this.size());
            }
        }

        return other;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "data=" + Arrays.toString(data) +
                ", t=" + t +
                '}';
    }

    /**
     * Reverse an array using the stack
     *
     * @param e   {E[]} any generic array
     * @param <E> allows for autoboxing between array to arraystack
     */
    public static <E> void reverse(E[] e) {
        //temporarily store the stack as is
        Stack<E> buffer = new ArrayStack<>();
        for (int i = 0; i < e.length; i++) {
            buffer.push(e[i]);
        }

        //pop the buffer one by one to re-write the stack
        for (int i = 0; i < e.length; i++) {
            e[i] = buffer.pop();
        }
    }
}
