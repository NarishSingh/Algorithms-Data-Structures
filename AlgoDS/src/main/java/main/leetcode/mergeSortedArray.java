/*
88
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

Constraints:
-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
 */
package main.leetcode;

import java.util.Arrays;

public class mergeSortedArray {

    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            //start adding to the unfilled elements of num1, but must start from beinning of nums2
            nums1[i] = nums2[j];
        }

        //sort it
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = new int[m + n]; //6 total
        int[] nums2 = new int[n];

        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;

        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;

        merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.println(num);
        }
    }
}
