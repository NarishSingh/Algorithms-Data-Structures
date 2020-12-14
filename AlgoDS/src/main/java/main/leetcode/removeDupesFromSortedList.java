/*
83
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
 */
package main.leetcode;

public class removeDupesFromSortedList {

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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        //create a reference to the head of result list,
        ListNode l = head;

        //while next is not null, walk the original list and omit duplicates
        while (head.next != null){
            if (head.val == head.next.val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return l; //since l references the now altered head, will return the full list
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        System.out.println(deleteDuplicates(l1).toString());
        System.out.println(deleteDuplicates(l2).toString());
    }
}
