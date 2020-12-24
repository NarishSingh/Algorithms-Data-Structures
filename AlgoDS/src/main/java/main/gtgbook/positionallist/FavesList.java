/*
Chap 7 fave list
Tracks the popularity of elements based on times accessed and stores them accordingly
 */
package main.gtgbook.positionallist;

import java.util.Iterator;

public class FavesList<E> {

    /**
     * Encapsulates the value of the entry and its access count
     *
     * @param <E> generic class
     */
    protected static class Item<E> {
        private final E value;
        private int count = 0;

        public Item(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            this.count++;
        }
    }

    /*fave list proper*/
    PositionalList<Item<E>> list = new LinkedPositionalList<>();

    public FavesList() {
    }

    /**
     * Get size of fave list
     *
     * @return {int} number of Items current in fave list
     */
    public int size() {
        return list.size();
    }

    /**
     * Access an element, and increase its access count
     *
     * @param e {E} the element to be accessed
     */
    public void access(E e) {
        Position<Item<E>> p = findPosition(e);

        if (p == null) {
            p = list.addLast(new Item<E>(e));
        }

        p.getElement().increment();
        moveUp(p);
    }

    /**
     * Remove an Item
     *
     * @param e {E} element of the item to remove
     */
    public void remove(E e) {
        Position<Item<E>> p = findPosition(e);
        if (p != null) {
            list.remove(p);
        }
    }

/*
    public Iterable<E> getFavorites(int j) throws IllegalArgumentException {
        if (j < 0 || j > size()) {
            throw new IllegalArgumentException("Invalid amount");
        }

        PositionalList<E> result = new LinkedPositionalList<>();
        Iterator<Item<E>> itr = list.iterator();
        for (int i = 0; i < j; i++) {
            result.addLast(itr.next().getValue());
        }
        return result;
    }
 */

    /*helpers*/
    /**
     * Get an element at a given position
     *
     * @param p {Position} position of an Item
     * @return {E} the value of the item at this position
     */
    protected E value(Position<Item<E>> p) {
        return p.getElement().getValue();
    }

    /**
     * Count the times an item stored at given position has been accessed
     *
     * @param p {Position} position of an Item
     * @return {int} the access count
     */
    protected int count(Position<Item<E>> p) {
        return p.getElement().getCount();
    }

    /**
     * Find the position containing an element
     *
     * @param e {E} element to search for
     * @return {Position} Position of the item with that element, null if not found
     */
    protected Position<Item<E>> findPosition(E e) {
        Position<Item<E>> walk = list.first();
        while (walk != null && !e.equals(value(walk))) {
            walk = list.after(walk);
        }
        return walk;
    }

    /**
     * Move an Item up in fave list based on access count
     *
     * @param p {Position} position of Item
     */
    protected void moveUp(Position<Item<E>> p) {
        int ct = count(p);
        Position<Item<E>> walk = p;

        //walk list to pass smaller counts
        while (walk != list.first() && count(list.before(walk)) < ct) {
            walk = list.before(walk);
        }

        //remove p and insert in proper place
        if (walk != p) {
            list.addBefore(walk, list.remove(p));
        }
    }
}
