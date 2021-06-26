package main.hackerrank;

public class utopiantree {

    /**
     * Find the height of a tree of height 1 after n cycles, where the tree doubles height in spring, and +1 in summer
     *
     * @param n {int} number of growth cycles
     * @return height of the tree after cycles
     */
    private static int utopianTree(int n) {
        if (n <= 0) return 1;

        int h = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                h += 1;
            } else {
                h *= 2;
            }
        }

        return h;
    }

    public static void main(String[] args) {
        System.out.println(utopianTree(0));
        System.out.println(utopianTree(1));
        System.out.println(utopianTree(4));
    }
}
