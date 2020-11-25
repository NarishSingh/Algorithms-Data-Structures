/*
56
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= start i <= end i <= 104
 */
package main.leetcode;

import java.util.Arrays;

public class mergeIntervals {

    static public int[][] merge(int[][] intervals) {
        //edge case
        if (intervals.length == 1 || intervals.length == 0) {
            return intervals;
        }

        int[][] merged = new int[intervals.length][2]; //will at most be same length as param
        int j = 0; //index tracking for merged arr

        //check against neighbor ahead, ++ by 2 for entire arr
        for (int i = 0; i < intervals.length - 1; i += 2) {
            int low = intervals[i][0];
            int high = intervals[i][1];
            int nextLow = intervals[i + 1][0];
            int nextHigh = intervals[i + 1][1];

            //no merge -> nextLow>high, nextHigh > low

            //FIXME very close but this only works for even numbered arrays
            if ((high < nextHigh && high < nextLow) || ((low == high) || (nextLow == nextHigh))) {
                //no merge
                merged[j++] = new int[]{low, high};
                merged[j++] = new int[]{nextLow, nextHigh};
            } else if (low > nextLow && high <= nextHigh) {
                merged[j++] = new int[]{nextLow, nextHigh}; //i completely spanned by next
            } else if (low <= nextLow && high < nextHigh) {
                merged[j++] = new int[]{low, nextHigh}; //low to nextHigh spans both i and next
            } else if (low >= nextLow && high > nextHigh) {
                merged[j++] = new int[]{nextLow, high}; //nextLow to high spans both i and next
            } else {
                merged[j++] = new int[]{low, high}; //next completely spanned by i
            }
        }

        //shorten array if there is a difference in length
        if (j != intervals.length) {
            int[][] splice = new int[j][2];
            for (int i = 0; i < j; i++) {
                splice[i] = merged[i];
            }

            return splice;
        } else {
            return merged;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {0, 4}};
        int[][] intervals3 = {{1, 4}, {0, 1}};
        int[][] intervals4 = {{1, 4}, {0, 5}};
        int[][] intervals5 = {{1, 4}, {1, 5}};

        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge(intervals2)));
        System.out.println(Arrays.deepToString(merge(intervals3)));
        System.out.println(Arrays.deepToString(merge(intervals4)));
        System.out.println(Arrays.deepToString(merge(intervals5)));
    }
}
