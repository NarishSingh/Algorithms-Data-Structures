/*
118
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
 */
package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        pascal.add(List.of(1)); //tip is always 1

        if (numRows == 1) {
            return pascal;
        }

        pascal.add(List.of(1, 1)); //if >1 rows, 2nd row is always 1,1

        int rowSize = 2;
        while (rowSize < numRows) {
            List<Integer> row = new ArrayList<>(rowSize + 1);
            row.add(1); //head

            //middle sums

            row.add(1); //tail

            //push to triangle
            pascal.add(row);
            rowSize++;
        }

        return pascal;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(1));
    }
}
