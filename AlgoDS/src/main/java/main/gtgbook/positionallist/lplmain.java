package main.gtgbook.positionallist;

public class lplmain {

    public static void main(String[] args) {
        PositionalList<Integer> l = new LinkedPositionalList<>();

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
    }
}
