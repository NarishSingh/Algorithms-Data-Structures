package main.gtgbook.recursion;

import java.util.Arrays;
import java.util.Random;

public class binarysumlogn {

    /**
     * O(log n) implementation of summing up an array or subarray
     *
     * @param data {int[]} array
     * @param low  {int} lowest index to start summing
     * @param high {int} highest index to start summing
     * @return {int} sum of subarray
     */
    static int binarySum(int[] data, int low, int high) {
        if (low > high) {
            return 0;
        } else if (low == high) {
            return data[low];
        } else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] data = new int[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(500);
        }

        int[] data2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11};

        System.out.println(Arrays.toString(data));
        System.out.println(binarySum(data, 0, data.length - 1));
        System.out.println(binarySum(data2, 0, data2.length - 1));
    }
}
