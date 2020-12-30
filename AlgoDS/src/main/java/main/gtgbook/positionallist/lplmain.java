package main.gtgbook.positionallist;

import java.util.Iterator;

public class lplmain {

    /**
     * Sort using insertion sort
     *
     * @param l {PositionalList} a LinkedPositionalList of int
     */
    public static void insertionSort(PositionalList<Integer> l) {
        Position<Integer> marker = l.first();

        while (marker != l.last()) {
            //create a pivot after marker
            Position<Integer> pivot = l.after(marker);
            int val = pivot.getElement();

            if (val > marker.getElement()) {
                marker = pivot; //if in order, just move up the marker
            } else {
                //if out of order, walk backward to find proper place position
                Position<Integer> walk = marker;
                while (walk != l.first() && l.before(walk).getElement() > val) {
                    walk = l.before(walk);
                }

                //insert to sorted position
                l.remove(pivot);
                l.addBefore(walk, val);
            }
        }
    }

    public static void main(String[] args) {
        LinkedPositionalList<Integer> l = new LinkedPositionalList<>();

        System.out.println(l.isEmpty());
        Position<Integer> first = l.addFirst(1);
        l.addLast(2);
        System.out.println(l.first().getElement());
        System.out.println(l.last().getElement());

        System.out.println("\n" + l.before(l.last()).getElement());
        l.addBefore(l.last(), 9);
        System.out.println(l.before(l.last()).getElement());
        System.out.println(l.after(l.first()).getElement());
        System.out.println(l.isEmpty());
        System.out.println("Size = " + l.size());

        System.out.println("\n" + l.after(l.last()));
        System.out.println(l.before(l.first()));
        l.addAfter(l.last(), 99);
        System.out.println(l.last().getElement());
        l.set(l.last(), 5);
        System.out.println(l.last().getElement());

        Integer lastRemoved = l.remove(l.last());
        System.out.println("\n" + l.last().getElement());
        System.out.println("Removed = " + lastRemoved);

        System.out.println("\n" + l.first().getElement());
        Integer firstRemoved = l.remove(first);
        System.out.println(l.first().getElement());
        System.out.println("Removed = " + firstRemoved);

        /*Position iteration*/
        System.out.println("\nElements at Positions:");
        for (Position<Integer> p : l.positions()) {
            System.out.println(p.getElement());
        }

        /*Element iteration*/
        System.out.println("\nAll Elements:");
        Iterator<Integer> elemItr = l.iterator();
        while (elemItr.hasNext()) {
            System.out.println(elemItr.next());
        }

        /*sort*/
        LinkedPositionalList<Integer> l2 = new LinkedPositionalList<>();
        l2.addFirst(7);
        l2.addLast(9);
        l2.addLast(1);
        l2.addLast(65);
        l2.addLast(87);
        l2.addLast(3);
        insertionSort(l2);
        System.out.println("\n" + l2.first().getElement());
        System.out.println(l2.last().getElement());

        /*clone and equals*/
        try {
            LinkedPositionalList<Integer> cloned = l2.clone();
            System.out.println("\n" + cloned.first().getElement());
            System.out.println(cloned.last().getElement());
            System.out.println("Cloned equals?: " + l2.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
