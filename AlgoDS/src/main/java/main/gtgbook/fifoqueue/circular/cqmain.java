package main.gtgbook.fifoqueue.circular;

public class cqmain {

    public static void main(String[] args) {
        CircularQueue<Integer> cq = new LinkedCircularQueue<>();

        cq.enqueue(4);
        cq.enqueue(5);
        cq.enqueue(6);

        System.out.println("Empty?: " + cq.isEmpty());
        System.out.println("Size?: " + cq.size());
        System.out.println(cq.first());

        cq.dequeue();
        System.out.println(cq.first());

        cq.rotate();
        System.out.println(cq.first());
        cq.rotate();
        System.out.println(cq.first());
    }
}
