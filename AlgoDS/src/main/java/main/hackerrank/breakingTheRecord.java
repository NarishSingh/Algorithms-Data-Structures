package main.hackerrank;

import java.util.List;

public class breakingTheRecord {

    /**
     * Track how many times the max and min score has been broken
     *
     * @param scores List of scores for season
     * @return List of 2 integers of score record breaks, max score breaks, min score breaks
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int lowCt = 0;
        int highCt = 0;
        //init currents to first score
        int currentLow = scores.get(0);
        int currentHigh = scores.get(0);

        for (Integer score : scores) {
            if (score < currentLow) {
                currentLow = score;
                lowCt++;
            } else if (score > currentHigh) {
                currentHigh = score;
                highCt++;
            }
        }

        return List.of(highCt, lowCt);
    }

    public static void main(String[] args) {
        List<Integer> scores1 = List.of(10, 5, 20, 20, 4, 5, 2, 25, 1);
        List<Integer> scores2 = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);

        System.out.println(breakingRecords(scores1));
        System.out.println(breakingRecords(scores2));
    }
}
