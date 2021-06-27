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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //walkers for sll
        ListNode walkerL1 = l1;
        ListNode walkerL2 = l2;
        //string builder so we capture digits one at a time then reverse
        StringBuilder l1Str = new StringBuilder();
        StringBuilder l2Str = new StringBuilder();

        //traverse the sll's and get their nums -> are stored in reverse so parse after sb.reverse().toString()
        while (walkerL1.next != null) {
            l1Str.append(walkerL1.val);
            walkerL1 = walkerL1.next;
        }
        int num1 = Integer.parseInt(l1Str.reverse().toString());

        while (walkerL2.next != null) {
            l2Str.append(walkerL2.val);
            walkerL2 = walkerL2.next;
        }
        int num2 = Integer.parseInt(l2Str.reverse().toString());

        int sum = num1 + num2; //sum

        //new sb to reverse the sum from its char array
        StringBuilder sumStr = new StringBuilder();
        for (char c : String.valueOf(sum).toCharArray()) {
            sumStr.append(c);
        }
        char[] sumRevArr = sumStr.reverse().toString().toCharArray();

        //build final list node
        ListNode temp;
        ListNode reversedSumSll = null; //null flag to set head
        for (char c : sumRevArr) {
            temp = new ListNode(Integer.parseInt(String.valueOf(c)));
            if (reversedSumSll == null) {
                reversedSumSll = temp;
            } else {
                reversedSumSll.next = temp;
            }
        }

        return reversedSumSll;
    }

    public static void main(String[] args) {
        ListNode case1 = addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        );

        while (case1.next != null){
            System.out.println(case1.val);
            case1 = case1.next;
        }
    }
}
