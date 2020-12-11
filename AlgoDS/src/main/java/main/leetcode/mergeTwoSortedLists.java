/*
21
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Ex1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]
 
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 */
package main.leetcode;

import java.util.List;

public class mergeTwoSortedLists {

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

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //edge cases for null
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        //merged for return, head for sll construction
        ListNode merged = new ListNode(0);
        ListNode head = merged;

        //build merge -> merge lower value node, then move that sll forward
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                //equal -> add both
                head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            head = head.next; //move head forward
        }

        //if one list runs out
        while (l1 == null && l2 != null) {
            head.next = new ListNode(l2.val);
            l2 = l2.next;
            head = head.next;
        }

        while (l1 != null && l2 == null) {
            head.next = new ListNode(l1.val);
            l1 = l1.next;
            head = head.next;
        }

        return merged.next; //first node is blank, but next will have merged sll
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        System.out.println(mergeTwoLists(l1, l2).toString());
    }
}
