/*
also works by making smaller collections
create a random pivot
go thru the array and determine what should be to the left/< and what should be to the right/<
then put the pivot to the middle of those left/right determinations
move the pivot and continue
 */
package main.sorting;

import java.util.Arrays;

public class quicksort {

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; //select pivot, can be random, here is high
        int i = low - 1; //moves behind the increment j to ensure elements are shifted to left of pivot
        for (int j = low; j < high; j++) {
            //if lower, move to left of pivot
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //put the pivot in the middle
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5 };

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
