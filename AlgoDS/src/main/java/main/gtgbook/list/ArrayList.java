package main.gtgbook.list;

public class ArrayList<E> implements List<E> {
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

        for (int j = this.size - 1; j >= i; j--) {
            data[j + 1] = data[j];
        }

        data[i] = e;
        this.size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, this.size);
        E removed = data[i];
        for (int j = i; j < this.size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[this.size - 1] = null;
        size--;
        return removed;
    }

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
        for (int i = 0; i < this.size; i++) {
            temp[i] = data[i];
        }
        this.data = temp;
    }
}
