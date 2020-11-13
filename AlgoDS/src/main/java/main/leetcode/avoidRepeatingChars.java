/*
Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.
 */
package main.leetcode;

import java.util.Random;

public class avoidRepeatingChars {

    /*
    static String modifyString(String s) {
        Random r = new Random();

        while (s.contains("?")) {
            int i = s.lastIndexOf("?");
            char next = 0, prev = 0;

            if (i == 0) {
                next = s.charAt(i + 1);
            } else if (i == s.length() - 1) {
                prev = s.charAt(i - 1);
            } else {
                prev = s.charAt(i - 1);
                next = s.charAt(i + 1);
            }

            while (s.charAt(i) != prev && s.charAt(i) != next) {
                s = s.replace("\\?", String.valueOf((char) ('a' + r.nextInt() % 26)));
            }
        }

        return s;
    }
     */

    static String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    if ((i > 0 && arr[i - 1] == 'a' + j) || (i < arr.length - 1 && arr[i + 1] == 'a' + j)){
                        continue;
                    } else {
                        arr[i] = (char) ('a' + j);
                        break;
                    }
                }
            }
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String testCase = "?zs";
        String testCase2 = "ubv?w";
        String testCase3 = "j?qg??b";
        String testCase4 = "??yw?ipkj?";


        System.out.println(modifyString(testCase));
        System.out.println(modifyString(testCase2));
        System.out.println(modifyString(testCase3));
        System.out.println(modifyString(testCase4));
    }
}
