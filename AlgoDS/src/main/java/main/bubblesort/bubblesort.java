/*
Very inefficient sort -> each item is compared to its neighbors, and swaps if one out of order
large elements "bubble" up to the end of the collection
 */
package main.bubblesort;

import java.util.Arrays;

public class bubblesort {

    /**
     * Sort an array from low to high, swapping elements one by one until all sorted
     *
     * @param arr {int[]}
     * @return {int[]} sorted array low to high
     */
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //n-i because it doesn't go to the end every time
            for (int j = 0; j < (arr.length - i) - 1; j++) {
                //if a neighbor is smaller than i, swap it
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        int[] descending = bubbleSort(arr);

        System.out.println(Arrays.toString(descending));
    }
}
