/*
2. Add 2 numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

ex1
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
package main.leetcode;

import main.gtgbook.list.List;

public class add2Nums {

    /**
     * Nested Node class provided
     */
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
    }

    /**
     * Insert a node at the tail of a singly linked list
     *
     * @param root the root node
     * @param val  int value for appended node
     * @return the root node with appended node attached
     */
    private static ListNode insertNode(ListNode root, int val) {
        ListNode temp = new ListNode(val, null);
        ListNode walker;

        //if null sll, set head, else, traverse to tail and insert
        if (root == null)
            root = temp;
        else {
            walker = root;
            while (walker.next != null) {
                walker = walker.next;
            }
            walker.next = temp;
        }

        return root;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //this solution fails for massive numbers past long, doubles introduce a decimal which will break solution
        /*
        //string builder so we capture digits one at a time then reverse
        StringBuilder l1Str = new StringBuilder();
        StringBuilder l2Str = new StringBuilder();

        //traverse the sll's and get their nums -> are stored in reverse so parse after sb.reverse().toString()
        while (l1 != null) {
            l1Str.append(l1.val);
            l1 = l1.next;
        }
        long num1 = Long.parseLong(l1Str.reverse().toString());

        while (l2 != null) {
            l2Str.append(l2.val);
            l2 = l2.next;
        }
        long num2 = Long.parseLong(l2Str.reverse().toString()); // FIXME: 6/28/2021 fails for 9999999991

        long sum = num1 + num2;

        //new sb to reverse the sum from its char array
        StringBuilder sumStr = new StringBuilder();
        for (char c : String.valueOf(sum).toCharArray()) {
            sumStr.append(c);
        }
        char[] sumRevArr = sumStr.reverse().toString().toCharArray();

        //build final list node
        ListNode reversedSumSll = null; //null flag to check if head
        for (char c : sumRevArr) {
            reversedSumSll = insertNode(reversedSumSll, Integer.parseInt(String.valueOf(c)));
        }

        return reversedSumSll;
         */

        ListNode head = new ListNode(0);
        ListNode l3 = head;

        //since its in reverse order, we just have to add digits, BUT we need to carry over the 1 in case sum is >9
        int carry = 0;
        while (l1 != null || l2 != null) {
            //if null, add 0
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int currentSum = l1Val + l2Val + carry;

            //split carry from digit
            carry = currentSum / 10;
            int digit = currentSum % 10;

            //attach node
            l3.next = new ListNode(digit);

            //move all forward
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        //if last addition had a carry, need a new node
        if (carry > 0) {
            l3.next = new ListNode(carry);
            l3 = l3.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode case1 = addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3, null))),
                new ListNode(5, new ListNode(6, new ListNode(4, null)))
        );

        while (case1 != null) {
            System.out.println(case1.val);
            case1 = case1.next;
        }

        System.out.println("\n");

        ListNode case2 = addTwoNumbers(
                new ListNode(9, null),
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                                new ListNode(9, null))))))))))
        );

        while (case2 != null) {
            System.out.println(case2.val);
            case2 = case2.next;
        }
    }
}
