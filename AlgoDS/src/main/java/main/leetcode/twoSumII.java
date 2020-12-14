/*
167
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]

Constraints:
2 <= nums.length <= 3 * 104
-1000 <= nums[i] <= 1000
nums is sorted in increasing order.
-1000 <= target <= 1000
 */
package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        /*
        //dump to a hashmap with k number, v index+1 since not 0-based
        Map<Integer, Integer> nm = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            nm.put(numbers[i], i + 1);
        }

        //calc difference from target and lookup diff as key
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];

            if (nm.containsKey(diff)) {
                return new int[]{nm.get(numbers[i]), nm.get(diff)};
            }
        }

        return null;
         */

        int l = 0;
        int h = numbers.length - 1;

        while (l < h) {
            if (numbers[l] + numbers[h] == target) {
                return new int[]{++l, ++h};
            } else if (numbers[l] + numbers[h] < target) {
                l++;
            } else {
                h--;
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{2, 7, 11, 15};
        int[] n2 = new int[]{2, 3, 4};
        int[] n3 = new int[]{-1, 0};
        int[] n4 = new int[]{0, 0, 3, 4};

        System.out.println(Arrays.toString(twoSum(n1, 9)));
        System.out.println(Arrays.toString(twoSum(n2, 6)));
        System.out.println(Arrays.toString(twoSum(n3, -1)));
        System.out.println(Arrays.toString(twoSum(n4, 0))); //hashmap way fails this test
    }
}
