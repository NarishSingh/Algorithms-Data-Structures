/*
Take a big data set
move a few each into "buckets" within a set range
sort the buckets
then gather all the elements back together
-works best on a well distributed set -> to spread out or close won't be efficient
 */
package main.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bucketsort {

    static void bucketSort(Integer[] arr, int bucketSize) {
        if (arr.length <= 0) {
            return;
        }

        //find min and max to determine range of data and how to break up buckets
        int min = Collections.min(Arrays.asList(arr));
        int max = Collections.max(Arrays.asList(arr));
        int numOfBuckets = Math.round((max - min) / bucketSize + 1);
        ArrayList<ArrayList<Integer>> bucketContainer = new ArrayList<ArrayList<Integer>>();

        //make buckets
        for (int i = 0; i < numOfBuckets; i++) {
            bucketContainer.add(new ArrayList<Integer>());
        }

        //based on how big an element is, it goes into a diff bucket
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = Math.round((arr[i] - min) / bucketSize); //kind of like finding its percentile
            bucketContainer.get(bucketIndex).add(arr[i]);
        }

        //sort buckets internally
        for (int i = 0; i < numOfBuckets; i++) {
            Collections.sort(bucketContainer.get(i));
        }

        //gather buckets, get the sorted arr
        int index = 0;
        for (int i = 0; i < numOfBuckets; i++) {
            for (int j = 0; j < bucketContainer.get(i).size(); j++) {
                arr[index++] = bucketContainer.get(i).get(j);
            }
        }


        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 8, 1, 6, 2, 6, 1, 0, 5, 2, 3};

        //we will time it
        long startTime = System.nanoTime();
        bucketSort(arr, 2);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println(duration + " ns");
    }
}
