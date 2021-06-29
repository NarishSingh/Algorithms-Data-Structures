/*
Attempt with an sll
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
