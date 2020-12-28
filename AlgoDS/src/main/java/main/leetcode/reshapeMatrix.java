/*
566
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.
 */
package main.leetcode;

import java.util.Arrays;

public class reshapeMatrix {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        //edge: if reshape impossible return original array
        if ((nums[0].length * nums.length) < (r * c)) {
            return nums;
        }

        //dump matrix to 1D array with row traversing order
        int[] all = new int[r * c];
        int k = 0; //all arr indexer
        for (int[] num : nums) {
            for (int i : num) {
                all[k++] = i;
            }
        }

        //assemble new matrix based on r c
        k = 0; //start indexer from beginning
        int[][] rsp = new int[r][c];
        for (int i = 0; i < rsp.length; i++) {
            for (int j = 0; j < rsp[i].length; j++) {
                rsp[i][j] = all[k++];
            }
        }

        return rsp;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int r2 = 2;
        int c2 = 4;

        System.out.println(Arrays.deepToString(matrixReshape(nums, r, c)));
        System.out.println(Arrays.deepToString(matrixReshape(nums, r2, c2)));
    }
}
