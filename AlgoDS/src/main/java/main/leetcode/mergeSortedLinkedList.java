/*
21
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]

Constraints:
-The number of nodes in both lists is in the range [0, 50].
- -100 <= Node.val <= 100
-Both l1 and l2 are sorted in non-decreasing order.
 */
package main.leetcode;

import java.util.List;

public class mergeSortedLinkedList {

    /**
     * Singly linked List implementation, provided by problem
     */
    /*
    static public class ListNode {
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
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged;

        //dump to one list
        for (ListNode ln :
                l1) {
            merged = new ListNode(ln.val, new ListNode(ln.next.val);
        }

        //sort

        return merged;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(mergeTwoLists(l1, l2));
    }

     */
}
