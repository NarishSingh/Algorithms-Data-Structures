package main.hackerrank;

public class Compare2Sll {
    private static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Compare 2 sll's
     *
     * @param head1 head of 1st sll
     * @param head2 head of 2nd sll
     * @return true if deep equality, false otherwise
     */
    private static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode walker1 = head1;
        SinglyLinkedListNode walker2 = head2;

        //start walking head1
        while (walker1 != null) {
            if (walker1.data != walker2.data) return false;
            if (walker1.next == null && walker2.next == null) return true; //deep equality and both can't step -> equal

            //if walker1 stepped but walker2 can't step -> unequal
            walker1 = walker1.next;
            if (walker2.next == null) return false;
            else walker2 = walker2.next;
        }

        //at this point walker1 is null, if no previous checks triggered then walker2 must still have nodes -> unequal
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode test1 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2,
                new SinglyLinkedListNode(3, null)));
        SinglyLinkedListNode other1 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2,
                new SinglyLinkedListNode(3, new SinglyLinkedListNode(4, null))));

        System.out.println(compareLists(test1, other1));
    }
}
