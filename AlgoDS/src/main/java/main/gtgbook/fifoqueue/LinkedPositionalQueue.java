package main.gtgbook.fifoqueue;

import main.gtgbook.positionallist.LinkedPositionalList;
import main.gtgbook.positionallist.Position;

public class LinkedPositionalQueue<E> implements Queue<E>, Cloneable {

    LinkedPositionalList<E> list = new LinkedPositionalList<>();

    public LinkedPositionalQueue() {
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

    public Position<E> enqueuePosition(E e){
        return list.addLast(e);
    }

    @Override
    public E first() {
        return list.first().getElement();
    }

    @Override
    public E dequeue() {
        return list.remove(list.first());
    }

    public E remove(Position<E> p){
        return list.remove(p);
    }

    @Override
    public String toString() {
        return "LinkedPositionalQueue{" +
                "list=" + list +
                '}';
    }
}
