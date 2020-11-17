/*
1528
Given a string s and an integer array indices of the same length.

The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string

Example 1:
Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

Example 2:
Input: s = "abc", indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in its position.

Example 3:
Input: s = "aiohn", indices = [3,1,4,2,0]
Output: "nihao"

Example 4:
Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
Output: "arigatou"

Example 5:
Input: s = "art", indices = [1,0,2]
Output: "rat"

Constraints:
s.length == indices.length == n
1 <= n <= 100
s contains only lower-case English letters.
0 <= indices[i] < n
All values of indices are unique (i.e. indices is a permutation of the integers from 0 to n - 1).
 */
package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class shuffleString {

    static public String restoreString(String s, int[] indices) {
        /*TREEMAP WAY*/
        //create treemap
        Map<Integer, Character> sMap = new TreeMap<>();

        //push k from indices and v of char in string, treemap will internally sort
        for (int i = 0; i < s.length(); i++) {
            sMap.put(indices[i], s.charAt(i));
        }

        //cast to string and return
        final String[] restored = {""};
        sMap.forEach((k, v) -> restored[0] = restored[0].concat(String.valueOf(v)));

        return restored[0];

        /*HASHMAP WAY*/
        /*
        String restored = "";

        //create hashmap
        Map<Integer, Character> sMap = new HashMap<>();

        //push k from indices and v of char in string
        for (int i = 0; i < s.length(); i++) {
            sMap.put(indices[i], s.charAt(i));
        }

        //sort indices arr and use sort to pull out chars from hashmap in order
        Arrays.sort(indices);

        for (int i = 0; i < indices.length; i++) {
            restored = restored.concat(String.valueOf(sMap.get(i)));
        }

        return restored;
         */
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3}; //is always size of s.length()
         /*
        String s = "aiohn";
        int[] indices = {3,1,4,2,0};

         */

        System.out.println(restoreString(s, indices));
    }
}
