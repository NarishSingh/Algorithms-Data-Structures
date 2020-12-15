/*
344
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
package main.leetcode;

import java.util.Arrays;

public class reverseStringInPlace {

    public static void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        int mid = s.length / 2;

        //walk from then ends inward, swapping chars, until mid point is reached
        for (int i = 0; i < mid; i++) {
            char temp = s[low];
            s[low++] = s[high];
            s[high--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] arr1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] arr2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        reverseString(arr1);
        reverseString(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
