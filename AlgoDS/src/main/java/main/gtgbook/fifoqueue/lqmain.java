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

        //concatenate
        LinkedQueue<Integer> q1 = new LinkedQueue<>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        LinkedQueue<Integer> q2 = new LinkedQueue<>();
        q2.enqueue(4);
        q2.enqueue(5);
        q2.enqueue(6);
        System.out.println("Q1 = " + q1.toString());
        System.out.println("Q2 = " + q2.toString());
        LinkedQueue<Integer> qc = q1.concatenate(q2);
        System.out.println("Combined = " + qc.toString());
    }
}
