/*
Take a big data set
move a few each into "buckets" within a set range
sort the buckets
then gather all the elements back together
-works best on a well distributed set -> to spread out or close won't be efficient
 */
package main.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bucketsort {

    /**
     * Sort from low to high, scattering data into buckets, sorting, then re-gathering
     *
     * @param arr        {Integer[]}
     * @param bucketSize {int} choose bucket size based on volume and scatter of data coming in
     * @return {Integer[]} sorted array
     */
    static Integer[] bucketSort(Integer[] arr, int bucketSize) {
        if (arr.length <= 0) {
            return arr;
        }

        //find min and max to determine range of data and how to break up buckets
        int min = Collections.min(Arrays.asList(arr));
        int max = Collections.max(Arrays.asList(arr));
        int numOfBuckets = Math.round((max - min) / bucketSize + 1);

        //create container and buckets
        ArrayList<ArrayList<Integer>> container = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++) {
            container.add(new ArrayList<>());
        }

        //based on how big an element is, it goes into a diff bucket
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = Math.round((arr[i] - min) / bucketSize); //kind of like finding its percentile
            container.get(bucketIndex).add(arr[i]);
        }

        //sort buckets internally
        for (int i = 0; i < numOfBuckets; i++) {
            Collections.sort(container.get(i));
        }

        //gather buckets, get the sorted arr
        int index = 0;
        for (int i = 0; i < numOfBuckets; i++) {
            for (int j = 0; j < container.get(i).size(); j++) {
                arr[index++] = container.get(i).get(j);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 8, 1, 6, 2, 6, 1, 0, 5, 2, 3};

        //we will time it
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(bucketSort(arr, 2)));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000;
        System.out.println(duration + " µs");
    }
}
