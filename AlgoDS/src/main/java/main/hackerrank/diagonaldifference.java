package main.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class diagonaldifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        //convert to array
        int n = arr.get(0).size(); //since square, row and col length will be the same
        int[][] matrix = new int[n][n];
        for (int i = 0; i < arr.size(); i++) {
            matrix[i] = arr.get(i).stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

//        System.out.println(Arrays.deepToString(matrix));

        int lrSum = 0;
        int rlSum = 0;
        int lr = 0;
        int rl = n - 1;

        while (lr < n) {
            /*
            lr diag -> lr,lr
            rl diag -> lr, rl
            lr must ++ and rl must -- after both computed
             */
            lrSum += matrix[lr][lr];
            rlSum += matrix[lr++][rl--];
//            System.out.println(lrSum);
//            System.out.println(rlSum + "\n");
        }

        return Math.abs(lrSum - rlSum);
    }

    public static void main(String[] args) {
        /*
        11 2 4
        4  5 6
        10 8 -12
         */

        List<Integer> row1 = new ArrayList<>();
        row1.add(11);
        row1.add(2);
        row1.add(4);
        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        List<Integer> row3 = new ArrayList<>();
        row3.add(10);
        row3.add(8);
        row3.add(-12);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(row1);
        arr.add(row2);
        arr.add(row3);

        System.out.println(diagonalDifference(arr));
    }
}
