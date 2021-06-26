/*
all about decreasing the amount of comparisons
break apart into smaller lists/arrays
sort in this smaller units
merge back into a major arr
-uses recursion to make it work
 */
package main.sorting;

import java.util.Arrays;

public class mergesort {

    /**
     * Combine two subarray's
     *
     * @param left  {int[]} subarray
     * @param right {int[]} subarray
     * @return {int[]} a combined and sorted array
     */
    static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0; //left, right, answers index
        int[] result = new int[left.length + right.length];

        //compare the front of each array pushing in the smaller one and incrementing the indices
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        //the above while loop assumes left and right are symmetrical, but if one runs out then sweep in the remaining
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    /**
     * Recursively sort an array from low to high by splitting and merging
     *
     * @param arr {int[]}
     * @return {int[]}
     */
    static int[] sort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return arr;
        }

        //split into smaller arr's
        int mid = Math.round(n / 2); //middle index
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        //load up the two subarrays
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        return merge(sort(left), sort(right)); //sort and merge recursively
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 6, 0, 2, 1, 4};

        System.out.println(Arrays.toString(sort(arr)));
    }
}
