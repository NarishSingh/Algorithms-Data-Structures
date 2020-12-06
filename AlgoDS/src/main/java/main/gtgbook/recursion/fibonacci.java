package main.gtgbook.recursion;

public class fibonacci {

    /**
     * Recursively sum up the fibonacci numbers for input
     *
     * @param n {int} Fn
     * @return {long[]} array of the fibonacci number and its previous computation, needed for recursion
     */
    static long[] fibonacciArr(int n) {
        if (n <= 1) {
            return new long[]{n, 0};
        } else {
            //doing a binary recursion for fn + fn-1 is very inefficient
            //workaround = doing running sum by storing to array
            long[] temp = fibonacciArr(n - 1);
            return new long[]{temp[0] + temp[1], temp[0]};
        }
    }

    /**
     * Calculate a fibonacci number
     *
     * @param n {int} Fn
     * @return {long} the result
     */
    static long fibo(int n) {
        return fibonacciArr(n)[0];
    }

    public static void main(String[] args) {
        System.out.println(fibo(10));
    }
}
