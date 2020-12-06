/*
238
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
Note: Please solve it without division and in O(n).

Follow up: Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class productArraySansSelf {

    static int[] productExceptSelf(int[] nums) {
        /*
        //create results arr and init all to 1
        int[] results = new int[nums.length];
        Arrays.fill(results, 1);

        //use stream to iterate and multiply all but the reference value
        for (int i = 0; i < nums.length; i++) {
            //finals for lambda
            final int idx = i;
            final int ref = nums[i];
            Arrays.stream(nums)
                    .forEach(num -> {
                        if (num != ref) { //FIXME breaks at duplicates and 0
                            results[idx] *= num;
                        }
                    });
        }

        return results;
         */

        //FIXME this is even worse than the last one
        int[] results = new int[nums.length];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> keys = numMap.keySet();
            keys.remove(nums[i]);
            results[i] = 1;

            for (Integer k : keys) {
                results[i] *= numMap.get(k);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
