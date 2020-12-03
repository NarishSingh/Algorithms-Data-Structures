/*
Binary search algorithm
with some refactoring
 */
package main.gtgbook.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinarySearch {

    /**
     * Perform binary search on an array
     *
     * @param data   {int[]} data to search through
     * @param target {int} what to search for
     * @param low    {int} the lower bound index to search from
     * @param high   {int} the upper bound index to search from
     * @return {boolean} true if target is present
     */
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;

            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1); //search through lower half of array
            } else {
                return binarySearch(data, target, mid + 1, high); //search through upper half of array
            }
        }
    }

    public static boolean binarySearchWithSort(int[] data, int target, int low, int high) throws IllegalAccessException {
        if (low < 0 || high > data.length) {
            throw new IllegalAccessException("Search will be out of bounds");
        } else if (low > high) {
            return false;
        } else {
            Arrays.sort(data);

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


    public static void main(String[] args) {
        Random rand = new Random();
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("===Sorted===");
        System.out.println(Arrays.toString(data));
        System.out.println(binarySearch(data, 8, 0, data.length));

        Integer[] unsorted = new Integer[10];
        unsorted[0] = 9;
        for (int i = 1; i < unsorted.length; i++) {
            unsorted[i] = rand.nextInt(1000);
        }
        List<Integer> unsList = Arrays.asList(unsorted);
        Collections.shuffle(unsList);
        int[] data2 = unsList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("\n===unsorted===");
        System.out.println(Arrays.toString(unsorted));
        try {
            System.out.println(binarySearchWithSort(data2, 9, 0, unsorted.length));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
