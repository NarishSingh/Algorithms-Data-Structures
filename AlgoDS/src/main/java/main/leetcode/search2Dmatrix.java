/*
74
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false

Example 3:
Input: matrix = [], target = 0
Output: false
 */
package main.leetcode;

public class search2Dmatrix {

    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;

            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1);
            } else {
                return binarySearch(data, target, mid + 1, high);
            }
        }
    }

    static public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //num of rows
        if (m <= 0) {
            return false;
        }

        int n = matrix[0].length; //row length
        if (n <= 0) {
            return false;
        }

        //find row target would be in
        for (int i = 0; i < m; i++) {
            //if within row's bounds, binary search there
            if (target == matrix[i][0] || target == matrix[i][n - 1]) {
                return true;
            } else if (target > matrix[i][0] && target < matrix[i][n - 1]) {
                return binarySearch(matrix[i], target, 0, n - 1);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;

        int[][] matrix2 = new int[][]{{1}};
        int target2 = 1;

        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix(matrix2, target2));
    }
}
