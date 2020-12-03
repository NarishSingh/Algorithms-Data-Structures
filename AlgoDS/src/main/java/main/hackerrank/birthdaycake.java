package main.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class birthdaycake {

    public static int birthdayCakeCandles(List<Integer> candles) {
        //find tallest candles
        Integer tallest = candles.stream()
                .max(Integer::compare)
                .orElse(null);

        //filter than count
        long blow = candles.stream()
                .filter(i -> i.equals(tallest))
                .count();

        return (int) blow;
    }

    public static void main(String[] args) {
        List<Integer> candles = new ArrayList<>();
        candles.add(3);
        candles.add(2);
        candles.add(1);
        candles.add(3);

        System.out.println(birthdayCakeCandles(candles));
    }
}
