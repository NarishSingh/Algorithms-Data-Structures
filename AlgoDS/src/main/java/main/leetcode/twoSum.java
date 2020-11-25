/*
1
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
- 2 <= nums.length <= 103
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- Only one valid answer exists.
 */
package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {

    static public int[] twoSumInArr(int[] nums, int target) {
        //brute force, submitted
        /*
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
         */

        //one pass hash table solution, o1 time bc of table ht lookup
        Map<Integer, Integer> map = new HashMap<>();

        //traverse array, putting to table, while also checking if two sum is there
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //if complement to i was already added, pull it out and return
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }

            //if not, just keep adding to ht
            map.put(nums[i], i); //since we return indices, make the actual element the key
        }

        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(twoSumInArr(nums, target)));
    }
}
