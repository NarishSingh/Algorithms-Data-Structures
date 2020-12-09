package main.gtgbook.fifoqueue.circular;

public class JosephusProblem {

    /**
     * Solve the hot potato/Josephus problem
     *
     * @param queue {CircularQueue} generic circular queue
     * @param k     {int} num of passes = rotations of circular queue
     * @param <E>   generic typing
     * @return {E} the removed element
     */
    public static <E> E josephus(CircularQueue<E> queue, int k) {
        if (queue.isEmpty()) {
            return null;
        }

        while (queue.size() > 1) {
            //skip past k-1 elements
            for (int i = 0; i < k - 1; i++) {
                queue.rotate();
            }

            //remove loser
            E e = queue.dequeue();
            System.out.println(e + " is out");
        }

        //return the winner, the last or next element remaining
        return queue.dequeue();
    }

    /**
     * Build a circular queue from an array
     *
     * @param arr {E[]} generic array
     * @param <E> takes generics
     * @return {CircularQueue} a circular queue for the parameterized array
     */
    public static <E> CircularQueue<E> buildQueue(E arr[]) {
        CircularQueue<E> queue = new LinkedCircularQueue<>();

        for (int i = 0; i < arr.length; i++) {
            queue.enqueue(arr[i]);
        }

        return queue;
    }

    public static void main(String[] args) {
        String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[] a3 = {"Mike", "Roberto"};

        System.out.println("===1===");
        System.out.println("First winner is " + josephus(buildQueue(a1), 3) + "\n");
        System.out.println("===2===");
        System.out.println("Second winner is " + josephus(buildQueue(a2), 10) + "\n");
        System.out.println("===3===");
        System.out.println("Third winner is " + josephus(buildQueue(a3), 7) + "\n");
    }
}
