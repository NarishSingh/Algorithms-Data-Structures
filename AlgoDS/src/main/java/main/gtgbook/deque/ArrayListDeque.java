/*
R7.3
Deque with ArrayList data store
 */
package main.gtgbook.deque;

import main.gtgbook.list.ArrayList;
import main.gtgbook.list.List;

public class ArrayListDeque<E> implements Deque<E>, Cloneable {

    private List<E> data;
    private int size = 0;
    private static final int CAP = 16;

    public ArrayListDeque() {
        this(CAP);
    }

    public ArrayListDeque(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E first() {
        if (data.isEmpty()) {
            return null;
        }

        return data.get(0);
    }

    @Override
    public E last() {
        if (data.isEmpty()) {
            return null;
        }

        return data.get(this.size - 1);
    }

    @Override
    public void addFirst(E e) {
        this.data.add(0, e);
        this.size++;
    }

    @Override
    public void addLast(E e) {
        this.data.add(this.size++, e);
    }

    @Override
    public E removeFirst() {
        if (data.isEmpty()) {
            return null;
        }

        E removed = this.data.remove(0);
        this.size--;
        return removed;
    }

    @Override
    public E removeLast() {
        if (data.isEmpty()) {
            return null;
        }

        return this.data.remove(--this.size);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayListDeque<E> clone() throws CloneNotSupportedException {
        ArrayListDeque<E> clone = (ArrayListDeque<E>) super.clone();

        if (this.size() > 0) {
            for (int i = 0; i < this.data.size(); i++) {
                clone.data.set(i, this.data.get(i));
            }
        }

        return clone;
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
        ArrayListDeque<?> other = (ArrayListDeque<?>) o;

        //size test
        if (this.size() != other.size()) {
            return false;
        }

        //element test
        if (!this.data.equals(other.data)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ArrayListDeque{" +
                "data=" + data +
                ", size=" + size +
                '}';
    }
}
