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

        //clone and equals
        ArrayQueue<Integer> orig = new ArrayQueue<>(3);
        orig.enqueue(4);
        orig.enqueue(5);
        orig.enqueue(6);
        System.out.println("\nOriginal: " + orig.toString());
        try {
            ArrayQueue<Integer> cloned = orig.clone();
            System.out.println("Cloned: " + cloned.toString());
            System.out.println("Equals?: " + orig.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}


