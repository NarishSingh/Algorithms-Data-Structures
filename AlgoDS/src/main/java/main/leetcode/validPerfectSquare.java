/*
367
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.

Example 1:
Input: num = 16
Output: true

Example 2:
Input: num = 14
Output: false

Constraints:
1 <= num <= 2^31 - 1
 */
package main.leetcode;

public class validPerfectSquare {

    static public boolean isPerfectSquare(int num) {
        // y = x*x
        // x = y/x
        if (num == 1) {
            return true;
        }

        for (int i = 1; i < num; i++) {
            //cast to double to stop int division causing false positives
            if (i == (double) num / i) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int num = 2000105819;

        System.out.println(isPerfectSquare(num));
    }
}
