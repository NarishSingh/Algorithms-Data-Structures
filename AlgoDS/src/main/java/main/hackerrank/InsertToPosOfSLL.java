package main.hackerrank;

public class InsertToPosOfSLL {
    private static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        /**
         * THIS ONE USED BY HACKERRANK
         *
         * @param data value at node
         */
        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Insert an int into a SLL
     *
     * @param llist    head of SLL
     * @param data     int to insert
     * @param position position to insert, 0-based
     * @return head node
     */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode walker = llist;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        //traverse to position-1 to ensure its in that place
        for (int i = 0; i < position - 1; i++) walker = walker.next;

        SinglyLinkedListNode temp = walker.next; //save the Node after insertion point
        walker.next = newNode; //insert after walker
        newNode.next = temp; //link inserted node to temp

        return llist;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode test = new SinglyLinkedListNode(16, new SinglyLinkedListNode(13,
                new SinglyLinkedListNode(7, null)));
        SinglyLinkedListNode inserted = insertNodeAtPosition(test, 1, 2);

        while (inserted != null) {
            System.out.println(inserted.data);
            inserted = inserted.next;
        }
    }
}
