/*
best of the worst sorts
 */
package main.insertionsort;

import java.util.Arrays;

public class insertSort {

    /**
     * Sort from low to high, iterating from end and inserting lower elements closer to the beginning
     *
     * @param arr {int[]}
     * @return {int[]} sorted array
     */
    static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            //while you haven't reached the beginning of array AND previous element is greater than current
            while (j >= 0 && arr[j] > current) {
                //swap then decrement j so we can continue moving smaller elements down
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current; //move current to next unsorted position
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
