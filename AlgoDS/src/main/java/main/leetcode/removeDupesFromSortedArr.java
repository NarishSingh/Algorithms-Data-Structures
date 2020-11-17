/*
26
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:
Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.

Constraints:
- 0 <= nums.length <= 3 * 104
- -104 <= nums[i] <= 104
- nums is sorted in ascending order.
 */
package main.leetcode;

import java.util.Arrays;

public class removeDupesFromSortedArr {

    static public int removeDuplicates(int[] nums) {
        //this question is weird but it essentially wants manual tracking of the length
        /*
        nums = Arrays.stream(nums).distinct().toArray();

        return nums.length;
         */

        //this always misses the last one
        /*
        int len = 0; //manual length tracker
        int j = 1; //distinct only iterator
//        int i = 0; //full length iterator
        while (i < nums.length) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i++];
                len++;
            } else {
                i++;
            }
        }
         */

        //start from 1 because we are checking against the previous neighbor
        int len = 1; //manual length tracker
        int j = 1; //distinct only iterator

        for (int i = 1; i < nums.length; i++) {
            //if its not equal to prev, move to front as its unique
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
                len++;
            }
        }

        for (int n : nums) {
            System.out.println(n);
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1, 1, 2};

        System.out.println("New length: " + removeDuplicates(nums));
    }
}
