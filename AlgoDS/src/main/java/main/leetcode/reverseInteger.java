/*
7
Given a 32-bit signed integer, reverse digits of an integer.
Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0

Constraints:

-231 <= x <= 231 - 1
 */
package main.leetcode;

public class reverseInteger {

    public static int reverse(int x) {
        //return 0 if beyond bounds
        if (x <= Math.pow(-2, 31) || x >= Math.pow(2, 31) - 1) {
            return 0;
        }

        //edge: x is 1 digits
        if (Math.abs(x) < 10) {
            return x;
        }

        //convert to string then dump to char array
        char[] c = String.valueOf(Math.abs(x)).toCharArray(); //absolute value to omit the - from arr

        int lo = 0;
        int hi = c.length - 1;
        int mid = c.length / 2;

        //reverse order
        for (int i = 0; i < mid; i++) {
            char temp = c[lo];
            c[lo++] = c[hi];
            c[hi--] = temp;
        }

        //edge: need - at the front
        if (x < 0) {
            char[] temp = new char[c.length + 1]; //account for -
            temp[0] = '-';
            System.arraycopy(c, 0, temp, 1, c.length);
            c = temp;
        }

        //convert back to int and return
        try {
            return Integer.parseInt(String.copyValueOf(c));
        } catch (NumberFormatException e) {
            return 0; //can only return int, so when overflows for a long input return 0
        }
    }

    public static void main(String[] args) {
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;
        int x4 = 0;
        int x5 = 10;
        int x6 = 901000;
        int x7 = 1534236469; //this is supposed to be long?

        System.out.println(reverse(x1));
        System.out.println(reverse(x2));
        System.out.println(reverse(x3));
        System.out.println(reverse(x4));
        System.out.println(reverse(x5));
        System.out.println(reverse(x6));
        System.out.println(reverse(x7));
    }
}
