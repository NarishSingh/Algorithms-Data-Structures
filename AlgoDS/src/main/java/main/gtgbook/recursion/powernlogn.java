/*
Example of linear recursion
 */

package main.gtgbook.recursion;

public class powernlogn {

    /**
     * O(n) implementation of x^n
     *
     * @param x {double} base
     * @param n {int} exponent
     * @return {double} result
     */
    static double powerN(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * powerN(x, n - 1);
        }
    }

    /**
     * O(log n) implementation - using the difference between even and odd exponentiation, we can cut down on number of
     * recursive calls
     *
     * @param x {double} base
     * @param n {int} exponent
     * @return {double} result
     */
    static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = power(x, n / 2);
            double result = partial * partial;

            //if odd, x^n-1 = x^n/2 * x^n/2 -> x^n = x * (x^n/2 * x^n/2)
            if (n % 2 == 1) {
                result *= x;
            }

            //even, x^n/2 * x^n/2 = x^n
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerN(10, 2));

        System.out.println(power(9, 10));
    }
}
