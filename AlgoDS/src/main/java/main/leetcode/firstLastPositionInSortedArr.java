/*
34
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm with O(log n) runtime complexity?

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
- 0 <= nums.length <= 105
- -109 <= nums[i] <= 109
- nums is a non-decreasing array.
- -109 <= target <= 109
 */
package main.leetcode;


import java.util.Arrays;
import java.util.TreeMap;

public class firstLastPositionInSortedArr {

    static public int[] searchRange(int[] nums, int target) {
        //put to treemap to maintain order
        TreeMap<Integer, Integer> targetMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetMap.put(i, nums[i]);
            }
        }

        if (targetMap.isEmpty()) {
            return new int[]{-1, -1};
        } else {
            //first key is min, last key is max index
            return new int[]{targetMap.firstKey(), targetMap.lastKey()};
        }
    }

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
