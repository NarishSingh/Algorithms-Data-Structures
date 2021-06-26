package main.hackerrank;

public class viralads {

    /**
     * An ad is shown to 5 people, and everyday after, half of the people shown the day before will like and share the
     * ad to 3 friends.
     * Find the num of people sharing the ad after n days
     *
     * @param n num of days past
     * @return total num of people who have shared ad
     */
    private static int viralAdvertising(int n) {
        int recip = 5;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int liked = Math.floorDiv(recip, 2);
            recip = liked * 3;
            total += liked;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(viralAdvertising(3));
    }
}
