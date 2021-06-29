/*
Attempt with an sll

NOTE: apparently for this you can just use an ArrayList...just make sure the push and pop are lifo, best to do it from
end of list
 */
package main.leetcode;

public class minStackAttempt2 {

    public static class SinglyLinkedList {
        public static class Node {
            private int val;
            private Node next;

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public Node addFirst(int val){
            head = new Node(val, head);
            size++;

            if (size == 0) tail = head;

            return head;
        }

        public Node addLast(int val) {
            Node newest = new Node(val, null); //tail is linked to nothing

            if (size == 0) {
                head = newest;
            } else {
                tail.next = newest;
            }

            size++;

            return tail;
        }

        public void removeFirst(){
            if (size == 0) return; //if empty do nothing

            head = head.next;
            size--;

            if (size == 0) tail = null; //emptied, meaning no tail either
        }
    }

    /**
     * Additions and removals will be from the front of sll/head bc that produces o(1)
     */
    public static class MinStack {

        SinglyLinkedList data;

        public MinStack() {
            this.data = new SinglyLinkedList();
        }

        public void push(int val) {
            data.addFirst(val);
        }

        public void pop() {
            data.removeFirst();
        }

        public int top() {
            return data.head.val;
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            SinglyLinkedList.Node walker = data.head;

            while (walker != null){
                if (walker.val < min) min = walker.val;
                walker = walker.next;
            }

            return min;
        }
    }

    public static void main(String[] args) {
        minStack.MinStack test1 = new minStack.MinStack();
        test1.push(-2);
        test1.push(0);
        test1.push(-3);
        System.out.println(test1.getMin());
        test1.pop();
        System.out.println(test1.top());
        System.out.println(test1.getMin());
    }
}
