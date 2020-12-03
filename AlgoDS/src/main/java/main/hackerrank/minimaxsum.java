package main.hackerrank;

import java.util.Arrays;

public class minimaxsum {

    static void miniMaxSum(int[] arr) {
        //sort to ensure min sum is always first 4, max sum is always max sum
        Arrays.sort(arr);
        StringBuilder ans = new StringBuilder();

        long minSum = 0;
        for (int i = 0; i < 4; i++) {
            minSum += arr[i];
        }
        ans.append(minSum);
        ans.append(" ");

        long maxSum = 0;
        for (int i = 1; i < arr.length; i++) {
            maxSum += arr[i];
        }
        ans.append(maxSum);

        System.out.println(ans.toString());
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        miniMaxSum(arr);
    }
}
