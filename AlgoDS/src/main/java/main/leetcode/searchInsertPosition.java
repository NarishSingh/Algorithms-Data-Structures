/*
35
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0

Example 5:
Input: nums = [1], target = 0
Output: 0

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
package main.leetcode;

import java.util.Arrays;

public class searchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        //if outside of bounds, return the bound
        if (target <= nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        } else {
            //if nums is only 2 elements, at this point its clearly in the middle
            if (nums.length == 2) {
                return 1;
            }

            //else, use binary search to find index
            int mid = nums.length / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                //less than, recursively search lower half
                return searchInsert(Arrays.copyOfRange(nums, 0, mid), target);
            } else {
                //greater than, recursively search upper half
                return searchInsert(Arrays.copyOfRange(nums, mid + 1, nums.length), target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;
        int[] nums2 = {1};
        int[] nums3 = {1, 3};
        int target5 = 1;
        int[] nums4 = {1, 3, 5};
        int target6 = 4;

        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsert(nums, target2));
        System.out.println(searchInsert(nums, target3));
        System.out.println(searchInsert(nums, target4));
        System.out.println(searchInsert(nums2, target4)); // [1], 0
        System.out.println(searchInsert(nums3, target5)); // [1,3], 1
        System.out.println(searchInsert(nums3, target2)); // [1,3], 2
        System.out.println(searchInsert(nums4, target2)); // [1,3,5], 2
        System.out.println(searchInsert(nums4, target6)); // [1,3,5], 4 //FIXME is failing this test
    }
}
