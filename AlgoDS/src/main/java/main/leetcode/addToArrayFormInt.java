/*
989
For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

Example 1:
Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:
Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:
Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Example 4:
Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000

Note：
1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
If A.length > 1, then A[0] != 0
 */
package main.leetcode;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class addToArrayFormInt {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        //build a string of the int arr, parse and sum with BigInt bc they throw weird inputs
        StringBuilder sb = new StringBuilder();
        for (int j : A) {
            sb.append(j);
        }

        //FIXME can't use long, can't use BigInteger either. thanks leetcode
        BigInteger sum = new BigInteger(sb.toString()).add(new BigInteger(String.valueOf(K)));
//        long sum = Long.parseLong(sb.toString()) + K;

        //build list, casting from char to Integer and return
        char[] result = String.valueOf(sum).toCharArray();
        List<Integer> l = new ArrayList<>();
        for (char c : result) {
            l.add(Integer.parseInt(String.valueOf(c)));
        }

        return l;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
        int k1 = 34;

        System.out.println(addToArrayForm(a1, k1).toString());
    }
}
