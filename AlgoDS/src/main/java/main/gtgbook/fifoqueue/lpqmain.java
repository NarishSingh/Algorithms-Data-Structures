package main.gtgbook.fifoqueue;

import main.gtgbook.positionallist.Position;

public class lpqmain {

    public static void main(String[] args) {
        LinkedPositionalQueue<Integer> lpq = new LinkedPositionalQueue<>();
        Position<Integer> first = lpq.enqueuePosition(1);
        Position<Integer> second = lpq.enqueuePosition(2);
        lpq.enqueue(3);
        System.out.println("Empty?: " + lpq.isEmpty());
        System.out.println("Size =  " + lpq.size());
        System.out.println(lpq.first());

        lpq.dequeue();
        System.out.println("\n" + lpq.first());

        lpq.remove(second);
        System.out.println("\n" + lpq.first());
    }
}
