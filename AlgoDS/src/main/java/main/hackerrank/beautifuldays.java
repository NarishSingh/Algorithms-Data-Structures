package main.hackerrank;

import java.util.stream.IntStream;

public class beautifuldays {

    /**
     * Find the "reverse" of a number, ex. 12 -> 21, 120 -> 21
     *
     * @param n any int
     * @return the corresponding semantic reverse of a number
     */
    private static int reverse(int n) {
        char[] num = String.valueOf(n).toCharArray(); //dump to arr
        if (num.length == 1) return n; //edge where its just one digit

        //reverse iteration for num, forward iteration for reverse
        char[] reverse = new char[num.length];
        for (int i = num.length - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = num[i];
        }

        return Integer.parseInt(new String(reverse));
    }

    /**
     * Given a range, find the num of "beautiful days" where the abs of i-reverse(i) is divisible by k
     *
     * @param i start of range
     * @param j end of range
     * @param k divisor
     * @return num of ints that fit the "beautiful day" criteria
     */
    private static int beautifulDays(int i, int j, int k) {
        int bd = 0;
        int[] range = IntStream.rangeClosed(i, j).toArray(); //create arr within range

        for (int n : range) {
            if (Math.abs(n - reverse(n)) % k == 0) {
                bd++;
            }
        }

        return bd;
    }

    public static void main(String[] args) {
        System.out.println(beautifulDays(20, 23, 6));
    }
}
