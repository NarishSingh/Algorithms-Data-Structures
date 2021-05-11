/*
70 Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */
package main.leetcode;

public class climbingStairs {

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        int routeCt = 1; //every staircase can be traversed one at a time

        /*
        //if even, can be traversed 2 at a time
        if (n % 2 == 0) {
            routeCt++;
        }

        //the rest of the combos will be multiple 1's and 2's
        //multiples of 1 + constant 2 - imagine 2 is shifting places amongst all the ones, will always result in n-1 routes (think n=5 and n=6)
        //multiples of 2 + constant 1 -
        if (n > 2) {
            routeCt += (n - 1);
        }
         */

        return routeCt;
    }

    public static void main(String[] args) {
        int case1 = 2;
        int case2 = 3;
        int case3 = -1;

        System.out.println(climbStairs(case1));
        System.out.println(climbStairs(case2));
        System.out.println(climbStairs(case3));
//        System.out.println(climbStairs(case4));
    }
}
