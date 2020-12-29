package main.gtgbook.list;

import java.util.Iterator;

public class almain {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>(3);

        System.out.println("Empty?: " + l.isEmpty());
        l.add(0, 1);
        l.add(1, 2);
        l.add(0, 0);
        l.add(3,3); //will re-size dynamically
        System.out.println("Size = " + l.size());
        /*
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
         */
        System.out.println(l.toString());

        System.out.println("\n");

        /*clone and equals*/
        try {
            ArrayList<Integer> cloned = l.clone();
            System.out.println(cloned.toString());
            System.out.println("Clone Equals? = " + l.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println();

        /*iterator*/
        Iterator<Integer> lit = l.iterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.remove();
        }

        System.out.println(l.isEmpty());

        /*contains()*/
        ArrayList<Integer> test = new ArrayList<>(3);
        test.add(0, 0);
        test.add(1, 1);
        test.add(2, 2);
        //valid searches
        System.out.println("\n" + test.contains(0));
        System.out.println(test.contains(2));
        System.out.println(test.contains(99));
        //invalid searches - all should fail due to type
        System.out.println(test.contains("Bad type input"));
        System.out.println(test.contains(false));
        System.out.println(test.contains(1.23567));
        System.out.println(test.contains('X'));

        /*clear()*/
        test.clear();
        System.out.println("\nCleared?: " + test.isEmpty());
    }
}
