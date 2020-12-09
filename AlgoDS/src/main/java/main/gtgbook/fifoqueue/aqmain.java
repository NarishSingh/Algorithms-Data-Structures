package main.gtgbook.fifoqueue;

public class aqmain {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayQueue<>(3);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Empty?: " + q.isEmpty());
        System.out.println("Size?: " + q.size());
        System.out.println(q.first());

        q.dequeue();
        System.out.println(q.first());

    }
}


