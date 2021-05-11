/*
203
Remove all elements from a linked list of integers that have value val.

Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
package main.leetcode;

public class removeLinkedListElement {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        //FIXME not working
        ListNode walker = head;

        while (walker != null) {
            //check if value is the target
            if (walker.val == val) {
                //if match, remove by connecting to the following node, skipping the target ln
                head.next = head.next.next;
            }

            //move walker forward
            walker = walker.next;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        System.out.println(ln.toString());
        System.out.println(removeElements(ln, 6).toString());
    }
}
