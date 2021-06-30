package main.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SparseArrays {

    /**
     * Find the num of occurences of the strings in "queries" within "strings" list
     *
     * @param strings list of strings
     * @param queries list of strings to look for
     * @return list of int with the frequencies for each in "queries"
     */
    private static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> freq = new ArrayList<>();
        //for each query, stream to filter and count
        for (String q : queries) {
            long ct = strings.stream()
                    .filter(q::equals)
                    .count();
            freq.add((int) ct); //count() returns long, cast to int
        }

        return freq;
    }

    public static void main(String[] args) {
        System.out.println(matchingStrings(List.of("aba", "baba", "aba", "xzxb"), List.of("aba", "xzxb", "ab")));
        System.out.println(matchingStrings(List.of("def", "de", "fgh"), List.of("de", "lmn", "fgh")));
        System.out.println(matchingStrings(
                List.of("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn",
                        "sdaklfj", "asdjf"),
                List.of("abcde", "sdaklfj", "asdjf", "na", "basdn"))
        );
    }
}
