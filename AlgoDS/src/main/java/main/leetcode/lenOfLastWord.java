/*
58
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5

Example 2:
Input: s = " "
Output: 0

Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.
 */
package main.leetcode;

public class lenOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");

        if (arr.length == 0) {
            return 0;
        } else {
            return arr[arr.length - 1].length();
        }
    }

    public static void main(String[] args) {
        String s = "Hello world";
        String s2 = " ";

        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord(s2));
    }
}
