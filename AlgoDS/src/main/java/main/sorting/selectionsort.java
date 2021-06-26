package main.sorting;

import java.util.Arrays;

public class selectionsort {

    /**
     * Sort an array from low to high, iterating from beginning and selecting the smallest element found ahead of its index
     *
     * @param arr {int[]}
     * @return {int[]} sorted array low to high
     */
    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i; //track the iterator position when searching

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j; //find lowest ahead and assign that element to min index
                }
            }

            //use the swap in line 19 to perform the swap
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
