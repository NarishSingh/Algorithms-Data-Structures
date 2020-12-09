package main.gtgbook.fifoqueue;

public class lqmain {

    public static void main(String[] args) {
        Queue<Integer> lq = new LinkedQueue<>();

        lq.enqueue(7);
        lq.enqueue(8);
        lq.enqueue(9);

        System.out.println("Empty?: " + lq.isEmpty());
        System.out.println("Size?: " + lq.size());
        System.out.println(lq.first());

        lq.dequeue();
        System.out.println(lq.first());
    }
}
