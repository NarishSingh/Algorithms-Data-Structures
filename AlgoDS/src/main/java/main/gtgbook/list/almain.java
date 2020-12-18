package main.gtgbook.list;

import java.util.Iterator;

public class almain {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();

        System.out.println("Empty?: " + l.isEmpty());
        l.add(0, 1);
        l.add(1, 2);
        l.add(0, 0);
        System.out.println("Size = " + l.size());
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

        System.out.println("\n");

        /*iterator*/
        Iterator<Integer> lit = l.iterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.remove();
        }

        System.out.println(l.isEmpty());
    }
}
