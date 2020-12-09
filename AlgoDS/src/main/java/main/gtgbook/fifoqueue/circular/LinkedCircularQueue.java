package main.gtgbook.fifoqueue.circular;

import main.gtgbook.circularlinkedlist.CircularLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

    private CircularLinkedList<E> list = new CircularLinkedList<>();

    public LinkedCircularQueue() {
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
        list.addFirst(e);
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
    public void rotate() {
        if (!list.isEmpty()) {
            //remove first
            E removed = list.removeFirst();

            //add to back
            list.addLast(removed);
        }
    }
}
