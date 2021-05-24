package main.hackerrank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class migratoryBirds {
    /**
     * Find the most frequently sighted bird id - if 2 or more are equal, return the lowest id
     *
     * @param arr List of bird ids sighting
     * @return the id of the most frequently sighted bird
     */
    public static int migratoryBirds(List<Integer> arr) {
        return arr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }


    public static void main(String[] args) {
        List<Integer> birds = List.of(1, 4, 4, 4, 5, 3);

        System.out.println(migratoryBirds(birds));
    }
}
