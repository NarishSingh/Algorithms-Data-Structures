/*
172
Given an integer n, return the number of trailing zeroes in n!.
Follow up: Could you write a solution that works in logarithmic time complexity?

Example 1:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Example 3:
Input: n = 0
Output: 0

Constraints: 1 <= n <= 104
 */
package main.leetcode;

public class factorialTrailingZeroes {

    static public int trailingZeroes(int n) {
        double fct = 1;
        int zeroCt = 0;

        //perform factorial calc
        while (n > 0) {
            fct *= n--;
        }

        //convert number to char array
        char[] fctChars = String.valueOf(fct).toCharArray();

        //count zeros from the end
        //FIXME this fails for really long numbers bc it defaults to e notation
        int i = fctChars.length - 1;
        while (fctChars[i--] == '0'){
            zeroCt++;
        }

        return zeroCt;
    }

    public static void main(String[] args) {
        int n = 30;

        System.out.println(trailingZeroes(n));

    }
}
