package main.hackerrank;

import java.util.List;

public class appleAndOrange {

    /**
     * Find which apples and orange fall on the house, which is the inclusive range of s-t
     *
     * @param s       start point of house
     * @param t       end point of house
     * @param a       apple tree point
     * @param b       orange tree point
     * @param apples  apple fall points
     * @param oranges orange fall points
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        //apples
        long appleHits = apples.stream()
                .filter(n -> (a + n >= s && a + n <= t))
                .count();
        System.out.println(appleHits);

        //oranges
        long orangeHits = oranges.stream()
                .filter(n -> (b + n >= s && b + n <= t))
                .count();
        System.out.println(orangeHits);
    }

    public static void main(String[] args) {
        countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
    }
}
