package main.hackerrank;

import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class billDivision {

    /**
     * Figure out if Bill charged anna correctly, based on that anna must pay half of all items that were shared, not what she did not eat
     *
     * @param bill list of integers for the costs on the bill
     * @param k    the 0-based index that anna refused
     * @param b    what Anna was charged
     */
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int[] eaten = bill.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int annaSum = 0;
        for (int i = 0; i < eaten.length; i++) {
            if (i != k) {
                annaSum += eaten[i];
            }
        }
        annaSum /= 2;

        System.out.println(annaSum == b ? "Bon Appetit" : b - annaSum);
    }

    public static void main(String[] args) {
        bonAppetit(List.of(3, 10, 2, 9), 1, 12);
        bonAppetit(List.of(3, 10, 2, 9), 1, 7);
        bonAppetit(List.of(2,4,6), 2, 3);
        bonAppetit(List.of(2,4,6), 2, 6);
    }
}
