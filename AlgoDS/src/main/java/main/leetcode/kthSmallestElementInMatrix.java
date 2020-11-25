package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthSmallestElementInMatrix {

    static public int kthSmallest(int[][] matrix, int k) {
        //dump all to list
        List<Integer> mList = new ArrayList<>();
        for (int[] arr : matrix) {
            for (int n : arr) {
                mList.add(n);
            }
        }

        //dump to arr and sort, return k-1 to consider 0th index
        Integer[] arr = mList.toArray(new Integer[0]);
        Arrays.sort(arr);

        return arr[k-1];
    }

    public static void main(String[] args) {
        int k = 8;
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(kthSmallest(matrix, k));
    }
}
