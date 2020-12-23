/*
349
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:
Each element in the result must be unique.
The result can be in any order.
 */
package main.leetcode;

import java.util.*;

public class intersectionOf2Arrs {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>(); //set to ensure things are not added twice

        //Add to maps
        Map<Integer, Integer> n1m = new HashMap<>();
        Map<Integer, Integer> n2m = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            n1m.put(i, nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            n2m.put(i, nums2[i]);
        }

        //going through first map, look up in second map, and add to result array
        n1m.forEach((k, v) -> {
            if (n2m.containsValue(v)){
                resultSet.add(v);
            }
        });

        //convert list to arr and return
        return resultSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] nums3 = new int[]{4,9,5};
        int[] nums4 = new int[]{9,4,9,8,4};

        System.out.println(Arrays.toString(intersection(nums, nums2)));
        System.out.println(Arrays.toString(intersection(nums3, nums4)));
    }
}
