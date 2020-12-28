/*
557
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
package main.leetcode;

import java.util.Stack;

public class reverseWordsStringIII {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String[] revWords = new String[words.length];
        int i = 0; //revWords index

        for (String word : words) {
            //push to stack, then pop for reverse order
            Stack<Character> c = new Stack<>();
            for (char ch : word.toCharArray()) {
                c.push(ch);
            }

            StringBuilder rev = new StringBuilder();
            while (!c.isEmpty()) {
                rev.append(c.pop());
            }

            revWords[i++] = rev.toString();
        }

        //Rebuild string
        StringBuilder reversed = new StringBuilder();
        for (String rev : revWords) {
            reversed.append(rev);
            reversed.append(" ");
        }

        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }
}
