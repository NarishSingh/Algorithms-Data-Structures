package main.queue;

public class Queue {
    int arr[];
    int front;
    int rear;
    int capacity;
    int count;

    /**
     * ctor
     *
     * @param size
     */
    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    /**
     * Remove an element from the front, and push front forward +1 so there is a new front
     */
    public void dequeue() {
        //cant dequeue if empty
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing " + arr[front]);

        front = (front + 1) % capacity; //allow it to loop about to the beginning to write if needed
        count--;
    }

    /**
     * Insert an element to rear, Everytime something is added, rear elem moves up so last insertion is new rear
     *
     * @param item {int}
     */
    public void enqueue(int item) {
        //can't insert if full
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting " + item);

        rear = (rear + 1) % capacity; //allow it to loop about to the beginning to write if needed
        arr[rear] = item; //new item in
        count++;
    }

    /**
     * Peek at the front element
     * @return {int}
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("UnderFlow\nNo elements to dequeue");
        }
        return arr[front];
    }

    public int size() {
        return count;
    }

    public Boolean isEmpty() {
        return (size() == 0);
    }

    public Boolean isFull() {
        return (size() == capacity);
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        q.enqueue(6);
        q.dequeue();

        System.out.println("===============================");

         System.out.println("Front element is: " + q.peek());
         q.dequeue();
         System.out.println("Front element is: " + q.peek());

//        q.dequeue();
//
//        for (int i = 0; i < q.arr.length; i++) {
//            System.out.println(q.arr[i]);
//        }

        //   if (q.isEmpty())
        //     System.out.println("Queue Is Empty");
        //   else
        //     System.out.println("Queue Is Not Empty");
    }
}
