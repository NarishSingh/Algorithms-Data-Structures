/*
217
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
package main.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDupes {
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        return numSet.size() != nums.length;

        //streams way for fun
        /*
        //Map of the integer and frequency count
        Map<Integer, Long> numFreq = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //take the entry set, check if all match 0 or 1
        return !numFreq.values().stream()
                .allMatch(l -> l <= 1L);
         */
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
