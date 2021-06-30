package main.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    /**
     * Do a left rotation (shift all to left, circularly) on arr any num of times
     *
     * @param d   num of rotations
     * @param arr list of ints
     * @return the rotated list
     */
    private static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> rotated = new ArrayList<>(arr);

        for (int i = 0; i < d; i++) {
            int temp = rotated.remove(0);
            rotated.add(temp);
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(rotateLeft(4, List.of(1, 2, 3, 4, 5)));
    }
}
