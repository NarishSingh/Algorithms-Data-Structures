/*
1470
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Example 1:
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Example 2:
Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]

Example 3:
Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]

Constraints:
1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3
 */
package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class shuffleTheArray {

    static public int[] shuffle(int[] nums, int n) {
        List<Integer> combined = new ArrayList<>();

        //splice into 2 sub arrays of length n
        int[] subA = Arrays.copyOfRange(nums, 0, n);
        int[] subB = Arrays.copyOfRange(nums, n, nums.length);

        //recombine where one is pushed in from each to an arraylist
        for (int i = 0; i < n; i++) {
            combined.add(subA[i]);
            combined.add(subB[i]);
        }

        //cast list back to array
        return combined.stream().mapToInt(Integer::intValue).toArray();

        //shorter answer from discussion
        /*
        int l = nums.length;
        int[] ans = new int[l];

        int i = 0, j = 0;
        while (i < l && j < n) {
            ans[i] = nums[j];
            i++;
            ans[i] = nums[(l / 2) + j];
            i++;
            j++;
        }

        return ans;
         */
    }

    public static void main(String[] args) {
        int n = 3;
        int[] nums = {2, 5, 1, 3, 4, 7}; //length always = 2n

        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
}
