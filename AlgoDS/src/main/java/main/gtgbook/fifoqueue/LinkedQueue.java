package main.gtgbook.fifoqueue;

import main.gtgbook.singlylinkedlist.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedQueue() {
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "list=" + list +
                '}';
    }

    /**
     * Add all elements from parameterized linked queue
     * C6.29
     *
     * @param q2 {LinkedQueue} queue whose elements will be stripped and added to queue
     * @return {LinkedQueue} the combined linked queue
     */
    public LinkedQueue<E> concatenate(LinkedQueue<E> q2) {
        while (!q2.isEmpty()) {
            this.enqueue(q2.dequeue());
        }

        return this;
    }
}
