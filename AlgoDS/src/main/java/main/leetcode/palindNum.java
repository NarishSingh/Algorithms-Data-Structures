/*
9
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

Example 1:
Input: x = 121
Output: true

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Example 4:
Input: x = -101
Output: false

Constraints:
-231 <= x <= 231 - 1
 */
package main.leetcode;

public class palindNum {

    public static boolean isPalindrome(int x) {
        //edge: negatives are always false bc no number can have - at end
        if (x < 0) {
            return false;
        }

        //dump to char array, and walk from front and back to mid checking equality
        char[] xArr = String.valueOf(x).toCharArray();

        int h = 0; //head
        int t = xArr.length - 1; //tail
        int mid = xArr.length / 2;

        for (int i = 0; i < mid; i++) {
            if (xArr[h++] != xArr[t--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n1 = 121;
        int n2 = -121;
        int n3 = 10;
        int n4 = -101;

        System.out.println(isPalindrome(n1));
        System.out.println(isPalindrome(n2));
        System.out.println(isPalindrome(n3));
        System.out.println(isPalindrome(n4));
    }
}
