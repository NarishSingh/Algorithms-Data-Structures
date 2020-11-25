package main.dasguptaBook;

public class modularExponentiation {

    /**
     * Quickly perform modular exponentiation by repeating x mod N while continually squaring x
     *
     * @param x {int} base
     * @param y {int} exponent
     * @param N {int} modulo value
     * @return {double} result
     */
    static double modExp(int x, int y, int N) {
        if (y == 0) {
            return 1;
        }

        double z = modExp(x, (y / 2), N);

        if (y % 2 == 0) {
            return Math.pow(z, 2) % N;
        } else {
            return x * Math.pow(z, 2) % N;
        }
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 3;
        int N = 4;

        System.out.println(modExp(x, y, N));
    }
}
