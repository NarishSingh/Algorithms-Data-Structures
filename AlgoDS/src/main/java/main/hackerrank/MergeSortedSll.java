package main.hackerrank;

public class MergeSortedSll {
    private static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode() {
        }

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "SinglyLinkedListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * Merge 2 sorted sll's into 1 sorted sll
     *
     * @param head1 head node of 1st
     * @param head2 head node of 2nd
     * @return head of new sll
     */
    private static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode walker1 = head1;
        SinglyLinkedListNode walker2 = head1;

        SinglyLinkedListNode merged = new SinglyLinkedListNode(); //head
        SinglyLinkedListNode mergeBuilder = merged;

        while (walker1 != null || walker2 != null) {
            if (walker1 == null) {
                mergeBuilder.data = walker2.data;

                walker2 = walker2.next;
                mergeBuilder = mergeBuilder.next;
            } else if (walker2 == null) {
                mergeBuilder.data = walker1.data;

                walker1 = walker1.next;
                mergeBuilder = mergeBuilder.next;
            } else {
                //first becomes min between the 2 sll's Nodes at that position, next becomes the max
                mergeBuilder.data = Math.min(walker1.data, walker2.data);
                mergeBuilder.next = new SinglyLinkedListNode(Math.max(walker1.data, walker2.data));
                mergeBuilder = mergeBuilder.next.next; //have to step 2 forward since we set them already

                //traverse both sll's based on which can step
                if (walker1.next != null) walker1 = walker1.next;
                if (walker2.next != null) walker2 = walker2.next;
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode test1 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(3,
                new SinglyLinkedListNode(7, null)));
        SinglyLinkedListNode other1 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, null));

        System.out.println(mergeLists(test1, other1));
    }
}
