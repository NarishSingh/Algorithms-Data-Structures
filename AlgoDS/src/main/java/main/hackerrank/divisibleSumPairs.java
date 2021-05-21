package main.hackerrank;

import java.util.List;

public class divisibleSumPairs {

    /**
     * Find num of pairs in list whose sum is divisible by k
     *
     * @param n  size of list
     * @param k  divisor
     * @param ar list
     * @return num of pairs
     */
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int pairs = 0;

        for (Integer num : ar) {
            //k/ar[i] + ar[j] = 1
            Integer willSum = Math.abs(num - k); //abs to get the difference regardless of which is bigger
            if (ar.contains(willSum)) {
                pairs++;
            }

        }

        //need a way to get the other divisions...
        return pairs;

    }

    public static void main(String[] args) {
        List<Integer> ar1 = List.of(1, 3, 2, 6, 1, 2);

        System.out.println(divisibleSumPairs(6, 3, ar1));
    }
}
