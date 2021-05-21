package main.hackerrank;

public class numberLineJumps {

    /**
     * Given starting points on a line, calculate if 2 kangaroos will meet given their jump rate
     *
     * @param x1 K1 start position
     * @param v1 K1 rate m/jump
     * @param x2 K2 start position
     * @param v2 K2 rate m/jump
     * @return YES if they will meet, NO otherwise
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        /*
        V1x+X1 = V2x+X2
        V1x - V2x = X2 - X1
        x(V1-V2) = X2-X1
        x = X2-X1/V1-V2
        must be a whole, positive number to be true since always starting after 0 on a line
         */

        double meet = (double) (x2 - x1) / (v1 - v2);
        return meet % 1 == 0 && meet > 0
                ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2));
        System.out.println(kangaroo(0, 2, 5, 3));
    }
}
